-- テーブル削除
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS comedian_profile;
DROP TABLE IF EXISTS chat_room_list;
DROP TABLE IF EXISTS chat_detail;
DROP TABLE IF EXISTS comedy_style;
DROP TABLE IF EXISTS composer_profile;
DROP TABLE IF EXISTS content;
DROP TABLE IF EXISTS match_status;
DROP TABLE IF EXISTS oogiri_theme;
DROP TABLE IF EXISTS oogiri_answer;
DROP TABLE IF EXISTS oogiri_reaction;
DROP TABLE IF EXISTS own_comedy_style;
DROP TABLE IF EXISTS special_skill;
DROP TABLE IF EXISTS own_special_skill;
SET FOREIGN_KEY_CHECKS = 1;

-- 地方
CREATE TABLE area (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  area VARCHAR(255) NOT NULL COMMENT '地方',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT area_PKC PRIMARY KEY (id)
) COMMENT '地方';


-- 事務所
CREATE TABLE office (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  office_name VARCHAR(255) NOT NULL COMMENT '事務所名',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT office_PKC PRIMARY KEY (id)
) COMMENT '事務所';


-- ユーザー
CREATE TABLE user (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_address VARCHAR(255) NOT NULL COMMENT 'ユーザアドレス',
  user_name VARCHAR(255) NOT NULL COMMENT 'ユーザ名',
  user_name_kana VARCHAR(255) NOT NULL COMMENT 'ユーザ名(かな)',
  user_type TINYINT NOT NULL COMMENT '活動種別:1:芸人、2:作家',
  password VARCHAR(255) NOT NULL COMMENT 'パスワード',
  debut_dt DATE COMMENT '活動開始年月',
  gender TINYINT DEFAULT 0 COMMENT '性別:0:回答なし、1:男性、2:女性、3:男女',
  office_id INT COMMENT '事務所ID',
  area_id INT NOT NULL COMMENT '活動場所ID',
  self_introduction VARCHAR(500) COMMENT '自己紹介文',
  profile_img_path VARCHAR(255) COMMENT 'プロフィール画像',
  delete_flg TINYINT DEFAULT 0 NOT NULL COMMENT '退会フラグ',
  login_at DATETIME COMMENT 'ログイン日時',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT user_PKC PRIMARY KEY (id),
  CONSTRAINT user_FK1 FOREIGN KEY (office_id) REFERENCES office(id),
  CONSTRAINT user_FK2 FOREIGN KEY (area_id) REFERENCES area(id)
) COMMENT 'ユーザー';

-- 芸人プロフィール
CREATE TABLE comedian_profile (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_id INT NOT NULL COMMENT 'ユーザID',
  member_num INT NOT NULL COMMENT '活動人数',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT comedian_profile_PKC PRIMARY KEY (id),
  CONSTRAINT comedian_profile_FK1 FOREIGN KEY (user_id) REFERENCES user(id),
  INDEX comedian_profile_FK1 (user_id)
) COMMENT '芸人プロフィール';

-- チャットルームリスト
CREATE TABLE chat_room_list (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_comedian_id INT NOT NULL COMMENT '芸人ユーザID',
  user_composer_id INT NOT NULL COMMENT '作家ユーザID',
  create_at DATETIME NOT NULL COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT chat_room_list_PKC PRIMARY KEY (id),
  CONSTRAINT chat_room_list_FK1 FOREIGN KEY (user_composer_id) REFERENCES user(id),
  CONSTRAINT chat_room_list_FK2 FOREIGN KEY (user_comedian_id) REFERENCES user(id)
) COMMENT 'チャットルームリスト';

-- チャット詳細
CREATE TABLE chat_detail (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  chat_room_list_id INT NOT NULL COMMENT 'チャットルームリストID',
  send_user_id INT NOT NULL COMMENT '送信者ID',
  chat_message VARCHAR(500) NOT NULL COMMENT '送信文',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT chat_detail_PKC PRIMARY KEY (id),
  CONSTRAINT chat_detail_FK1 FOREIGN KEY (chat_room_list_id) REFERENCES chat_room_list(id),
  CONSTRAINT chat_detail_FK2 FOREIGN KEY (send_user_id) REFERENCES user(id),
  INDEX chat_detail_send_user_id_idx (send_user_id),
  INDEX chat_detail_chat_room_list_id_idx (chat_room_list_id)
) COMMENT 'チャット詳細';

-- 芸風マスタ
create table comedy_style (
  id int auto_increment not null comment 'ID'
  , style_name varchar(255) not null comment '芸風名'
  , create_at datetime comment '作成日時'
  , update_at datetime comment '更新日時'
  , constraint comedy_style_PKC primary key (id)
) comment '芸風マスタ' ;

-- 作家プロフィール
CREATE TABLE composer_profile (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_id INT NOT NULL COMMENT 'ユーザID',
  fee_type TINYINT NOT NULL COMMENT '料金体系:1:時給、2:成果物',
  fee INT NOT NULL COMMENT '金額',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT composer_profile_PKC PRIMARY KEY (id),
  CONSTRAINT composer_profile_FK1 FOREIGN KEY (user_id) REFERENCES user(id),
  INDEX composer_profile_user_id_idx (user_id)
) COMMENT '作家プロフィール';

-- 投稿
CREATE TABLE content (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_id INT NOT NULL COMMENT 'ユーザID',
  title VARCHAR(255) NOT NULL COMMENT 'タイトル',
  detail VARCHAR(255) NOT NULL COMMENT '詳細',
  top_img_path VARCHAR(255) COMMENT 'サムネイル画像',
  content_path VARCHAR(255) NOT NULL COMMENT '投稿ファイル',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT content_PKC PRIMARY KEY (id),
  CONSTRAINT content_FK1 FOREIGN KEY (user_id) REFERENCES user(id),
  INDEX content_user_id_idx (user_id)
) COMMENT '投稿';

-- マッチステータス
CREATE TABLE match_status (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  send_user_id INT NOT NULL COMMENT '送信者ID',
  receive_user_id INT NOT NULL COMMENT '受信者ID',
  match_status TINYINT NOT NULL COMMENT 'ステータス:00:未マッチ 10:マッチ済み 11:SuperLaugh 20:キャンセル済み 99:解除済み',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT match_status_PKC PRIMARY KEY (id),
  CONSTRAINT match_status_FK1 FOREIGN KEY (send_user_id) REFERENCES user(id),
  CONSTRAINT match_status_FK2 FOREIGN KEY (receive_user_id) REFERENCES user(id),
  INDEX match_status_receive_user_id_idx (receive_user_id),
  INDEX match_status_send_user_id_idx (send_user_id)
) COMMENT 'マッチステータス';

-- 大喜利お題
CREATE TABLE oogiri_theme (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_id INT NOT NULL COMMENT 'お題投稿ユーザID',
  theme_content VARCHAR(255) NOT NULL COMMENT 'お題内容',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT oogiri_theme_PKC PRIMARY KEY (id),
  CONSTRAINT oogiri_theme_FK1 FOREIGN KEY (user_id) REFERENCES user(id),
  INDEX oogiri_theme_user_id_idx (user_id)
) COMMENT '大喜利お題';

-- 大喜利回答
CREATE TABLE oogiri_answer (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  oogiri_theme_id INT NOT NULL COMMENT 'お題ID',
  user_id INT NOT NULL COMMENT '回答ユーザID',
  answer_content VARCHAR(500) NOT NULL COMMENT '回答内容',
  create_at DATETIME NOT NULL COMMENT '作成日時',
  delete_at DATETIME COMMENT '削除日時',
  CONSTRAINT oogiri_answer_PKC PRIMARY KEY (id),
  CONSTRAINT oogiri_answer_FK1 FOREIGN KEY (oogiri_theme_id) REFERENCES oogiri_theme(id),
  CONSTRAINT oogiri_answer_FK2 FOREIGN KEY (user_id) REFERENCES user(id),
  INDEX oogiri_answer_user_id_idx (user_id),
  INDEX oogiri_answer_oogiri_theme_id_idx (oogiri_theme_id)
) COMMENT '大喜利回答';

-- 大喜利リアクション
CREATE TABLE oogiri_reaction (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  oogiri_answer_id INT NOT NULL COMMENT '回答ID',
  user_id INT NOT NULL COMMENT 'リアクションユーザID',
  reaction_status TINYINT NOT NULL COMMENT 'ステータス:11:いいね、12:とてもいい、21:悪い、99:削除済み',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT oogiri_reaction_PKC PRIMARY KEY (id),
  CONSTRAINT oogiri_reaction_FK1 FOREIGN KEY (oogiri_answer_id) REFERENCES oogiri_answer(id),
  CONSTRAINT oogiri_reaction_FK2 FOREIGN KEY (user_id) REFERENCES user(id),
  INDEX oogiri_reaction_user_id_idx (user_id),
  INDEX oogiri_reaction_oogiri_answer_id_idx (oogiri_answer_id)
) COMMENT '大喜利リアクション';

-- 得意芸風
CREATE TABLE own_comedy_style (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  comedy_style_id INT NOT NULL COMMENT '芸風ID',
  user_id INT NOT NULL COMMENT 'ユーザID',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT own_comedy_style_PKC PRIMARY KEY (id),
  CONSTRAINT own_comedy_style_FK1 FOREIGN KEY (user_id) REFERENCES user(id),
  CONSTRAINT own_comedy_style_FK2 FOREIGN KEY (comedy_style_id) REFERENCES comedy_style(id),
  INDEX own_comedy_style_comedy_style_id_idx (comedy_style_id),
  INDEX own_comedy_style_user_id_idx (user_id)
) COMMENT '得意芸風';

-- 特殊スキルマスタ
create table special_skill (
  id int auto_increment not null comment 'ID'
  , special_skill_name varchar(255) not null comment '特殊スキル名'
  , create_at datetime comment '作成日時'
  , update_at datetime comment '更新日時'
  , constraint special_skill_PKC primary key (id)
) comment '特殊スキルマスタ' ;

-- ユーザー特殊スキル
CREATE TABLE own_special_skill (
  id INT AUTO_INCREMENT NOT NULL COMMENT 'ID',
  user_id INT NOT NULL COMMENT 'ユーザID',
  special_skill_id INT COMMENT '特殊スキルID',
  another_skill VARCHAR(20) COMMENT 'その他スキル',
  create_at DATETIME COMMENT '作成日時',
  update_at DATETIME COMMENT '更新日時',
  CONSTRAINT own_special_skill_PKC PRIMARY KEY (id),
  CONSTRAINT own_special_skill_FK1 FOREIGN KEY (user_id) REFERENCES user(id),
  CONSTRAINT own_special_skill_FK2 FOREIGN KEY (special_skill_id) REFERENCES special_skill(id),
  INDEX own_special_skill_user_id_idx (user_id),
  INDEX own_special_skill_special_skill_id_idx (special_skill_id)
) COMMENT 'ユーザー特殊スキル';

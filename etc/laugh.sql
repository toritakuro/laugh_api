-- Project Name : Laugh
-- Date/Time    : 2023/06/09 20:06:07
-- Author       : a_team
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

-- チャット
-- * RestoreFromTempTable
create table chat (
  chat_room_id INT not null comment 'チャットルームID'
  , send_user_id INT not null comment '送信者ID'
  , chat_message CHAR not null comment '送信文'
  , send_at DATETIME not null comment '送信日時'
  , create_at DATETIME comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint chat_PKC primary key (chat_room_id,send_user_id,send_at)
) comment 'チャット' ;

-- laugh
-- * RestoreFromTempTable
create table laugh (
  laugh_id INT not null comment 'LaughID'
  , soushin_user_id INT not null comment '送信者ID'
  , jushin_user_id INT not null comment '受信者ID'
  , soushin_at DATETIME not null comment '送信日時'
  , match_flag INT not null comment 'マッチフラグ:0:未マッチ 1:マッチ済み'
  , super_laugh_flag INT not null comment 'SuperLaughフラグ:0:laugh 1:SuperLaugh'
  , status INT not null comment 'ステータス:0:キャンセルしていない 1:送信者キャンセル 2:受信者キャンセル 3:解除'
  , create_at DATETIME comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint laugh_PKC primary key (laugh_id)
) comment 'laugh' ;

-- チャットルーム
-- * RestoreFromTempTable
create table chat_room (
  chat_room_id CHAR not null comment 'チャットルームID'
  , user_id1 INT not null comment 'ユーザーID1'
  , user_id2 INT not null comment 'ユーザーID2'
  , create_at DATETIME not null comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint chat_room_PKC primary key (chat_room_id)
) comment 'チャットルーム' ;

-- マッチング
-- * RestoreFromTempTable
create table matching (
  matching_id INT not null comment 'マッチングID'
  , user_id_2 CHAR not null comment 'ユーザーID2'
  , matched_at DATETIME not null comment 'マッチ日時'
  , kaijo_flag INT not null comment '解除フラグ'
  , constraint matching_PKC primary key (matching_id)
) comment 'マッチング' ;

-- 大喜利いいね
-- * RestoreFromTempTable
create table oogiri_good (
  answer_id INT not null comment '回答ID'
  , user_id INT not null comment 'いいねユーザID'
  , delete_flag INT not null comment '取消フラグ:0:取り消してない 1:取消済み'
  , create_at DATETIME not null comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint oogiri_good_PKC primary key (answer_id,user_id)
) comment '大喜利いいね' ;

-- 得意分野
-- * RestoreFromTempTable
create table tokui_bunya (
  user_id INT not null comment 'ユーザID'
  , id INT not null comment 'ID'
  , manzai INT not null comment '漫才:0:得意じゃない 1:得意'
  , conte INT not null comment 'コント:0:得意じゃない 1:得意'
  , pin INT not null comment 'ピン:0:得意じゃない 1:得意'
  , gyagu INT not null comment 'ギャグ:0:得意じゃない 1:得意'
  , monomane INT not null comment 'モノマネ:0:得意じゃない 1:得意'
  , other CHAR comment 'その他'
  , create_at DATETIME comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint tokui_bunya_PKC primary key (user_id,id)
) comment '得意分野' ;

-- 芸人プロフィール
-- * RestoreFromTempTable
create table geinin_profile (
  user_id INT not null comment 'ユーザID:メールアドレス'
  , debut_dt DATE not null comment '活動開始年月'
  , katsudo_ninzu INT not null comment '活動人数'
  , gender INT not null comment '性別'
  , shozoku_jimusho CHAR comment '事務所'
  , geifu INT not null comment '芸風'
  , katsudo_basho INT comment '活動場所'
  , jikoshokai VARCHAR comment '自己紹介文'
  , profile_img VARCHAR comment 'プロフィール画像'
  , create_at DATETIME comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint geinin_profile_PKC primary key (user_id)
) comment '芸人プロフィール' ;

-- 作家プロフィール
-- * RestoreFromTempTable
create table sakka_profile (
  user_id INT not null comment 'ユーザID'
  , debut_dt DATE not null comment '活動開始年月'
  , gender INT comment '性別'
  , jimusho CHAR comment '事務所'
  , ryokin_taikei INT not null comment '料金体系'
  , kingaku INT not null comment '金額'
  , tokushu_skill CHAR comment '特殊スキル'
  , katsudo_basho INT comment '活動場所'
  , jikoshokai VARCHAR comment '自己紹介文'
  , profile_img VARCHAR comment 'プロフィール画像'
  , update_at DATETIME comment '作成日時'
  , create_at DATETIME comment '更新日時'
  , constraint sakka_profile_PKC primary key (user_id)
) comment '作家プロフィール' ;

-- 投稿
-- * RestoreFromTempTable
create table content (
  file_id INT not null comment 'ファイルID'
  , user_id INT not null comment 'ユーザID'
  , title CHAR not null comment 'タイトル'
  , detail CHAR not null comment '詳細'
  , top_img VARCHAR comment 'サムネイル画像'
  , file VARCHAR not null comment 'ファイル'
  , create_at DATETIME not null comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint content_PKC primary key (file_id)
) comment '投稿' ;

-- 大喜利回答
-- * RestoreFromTempTable
create table oogiri_answer (
  answer_id INT not null comment '回答ID'
  , theme_id INT not null comment 'お題ID'
  , user_id INT not null comment '回答ユーザID'
  , answer_content VARCHAR not null comment '回答内容'
  , create_at DATETIME not null comment '作成日時'
  , update_at INT comment '更新日時'
  , delete_at DATETIME comment '削除日時'
  , constraint oogiri_answer_PKC primary key (answer_id)
) comment '大喜利回答' ;

-- 大喜利お題
-- * RestoreFromTempTable
create table oogiri_odai (
  theme_id INT not null comment 'お題ID'
  , user_id INT not null comment 'お題投稿ユーザID'
  , theme_content VARCHAR not null comment 'お題内容'
  , create_at DATETIME comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , constraint oogiri_odai_PKC primary key (theme_id)
) comment '大喜利お題' ;

-- ユーザー
-- * RestoreFromTempTable
create table user (
  id INT not null comment 'ID'
  , user_id CHAR not null comment 'ユーザID:メールアドレス'
  , user_name VARCHAR not null comment 'ユーザ名'
  , user_name_kana VARCHAR not null comment 'ユーザ名(かな)'
  , user_type INT not null comment '活動種別:0:作家、1:芸人'
  , password VARCHAR not null comment 'パスワード'
  , delete_flag INT comment '退会フラグ'
  , create_at DATETIME comment '作成日時'
  , update_at DATETIME comment '更新日時'
  , login_at DATETIME comment 'ログイン日時'
  , constraint user_PKC primary key (id)
) comment 'ユーザー' ;


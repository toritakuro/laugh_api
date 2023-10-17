-- テーブル削除
SET FOREIGN_KEY_CHECKS = 0;

-- 地域
insert into area (id, area) values (1, '北海道'),(2, '東北'),(3, '関東'),(4, '北陸甲信越'),(5, '中部'),(6, '関西'),(7, '中国'),(8, '四国'),(9, '九州');

-- 事務所
insert into office (id, office_name) values (1, 'アヴィラ'),(2, '浅井企画'),(3, 'ASH&Dコーポレーション'),(4, 'アミー・パーク'),(5, 'UMEDA芸能'),(6, 'FMG'),(7, 'MLクリエーション'),(8, '大川興業'),(9, '太田プロダクション'),(10, 'オフィス北野'),(11, 'オリジン・コーポレーション'),(12, 'お笑い集団ティーライズ'),(13, 'グレープカンパニー'),(14, 'ケイダッシュステージ'),(15, 'K-PRO'),(16, 'ザ・森東'),(17, 'サンミュージックプロダクション'),(18, 'SHUプロモーション'),(19, '松竹芸能'),(20, 'スパンキープロダクション'),(21, 'ソニー・ミュージックアーティスツ'),(22, 'タイタン'),(23, 'トゥインクル・コーポレーション'),(24, '徳間ジャパンコミュニケーションズ'),(25, 'どっかんプロ'),(26, 'トップ・カラー'),(27, 'ナチュラルエイト'),(28, 'ニュースタッフプロダクション'),(29, 'ノーリーズン'),(30, 'ファインステージ'),(31, 'プロダクション人力舎'),(32, 'プロデューサーハウスあ・うん'),(33, 'ホリプロ'),(34, 'ホリプロコム'),(35, 'マセキ芸能社'),(36, '三木プロダクション'),(37, '吉本興業'),(38, 'ワタナベエンターテインメント'),(39, 'ワハハ本舗'),(40, '無所属');

-- 芸風
insert into comedy_style (id, style_name) values (1, '漫才'),(2, 'ピン'),(3, 'コント'),(4, 'ギャグ'),(5, 'モノマネ'),(6, '歌ネタ'),(7, 'リズムネタ'),(8, 'その他');

-- 特殊スキル
insert into special_skill (id, special_skill_name) values (1, '動画編集'),(2, 'イラスト'),(3, '音源制作');

-- 利用者
insert into c4cup.`user`(id, user_address,user_name,user_name_kana,user_type,password,debut_dt,gender,office_id,area_id,self_introduction,profile_img_path,delete_flg,login_at,create_at,update_at) values 
    (1,'a@a','test','てすと','1','$2a$10$4.5qWU/J0IOj888EKpWr9.PoP6IF89AebM7lCCzCjoXwRvhssv7.C',null,'0',null,1,null,null,'0',TIMESTAMP '2023-09-27 12:56:28.000',null,null)
  , (2,'b@b','サメゾンビ','さめぞんび','1','$2a$10$VRUXCjV9CoaGli2PUTGGderirtno.5CA/QQlp3yhaDOXTp1eBRXKi',null,'0',null,1,null,null,'0',TIMESTAMP '2023-10-01 07:14:57.000',null,null)
  , (3,'c@c','ミルクボーイ','みるくぼーい','1','$2a$10$3BVoLnUhCi3ut9xRw82BHe4KgJTaRbJV4.Xfk5IgrztEFscc0iWrK',null,'0',null,1,null,null,'0',TIMESTAMP '2023-10-01 07:15:32.000',null,null)
  , (4,'d@d','マヂカルラブリー','まぢかるらぶりー','1','$2a$10$pYLegX5ywTgHXGnI7B.Jv.F.s6L3EKi6cDCXBnDLSWt5lRReT4bm6',null,'0',null,1,null,null,'0',null,null,null)
  ,(5,'a2@a','佐藤満春','さとうみつはる','2','$2a$10$4.5qWU/J0IOj888EKpWr9.PoP6IF89AebM7lCCzCjoXwRvhssv7.C',null,'0',null,1,null,null,'0',TIMESTAMP '2023-09-27 12:56:28.000',null,null)
  , (6,'b3@b','鈴木おさむ','すずきおさむ','2','$2a$10$VRUXCjV9CoaGli2PUTGGderirtno.5CA/QQlp3yhaDOXTp1eBRXKi',null,'0',null,1,null,null,'0',TIMESTAMP '2023-10-01 07:14:57.000',null,null)
  , (7,'c4@c','高須光聖','タカスミツヨシ','2','$2a$10$3BVoLnUhCi3ut9xRw82BHe4KgJTaRbJV4.Xfk5IgrztEFscc0iWrK',null,'0',null,1,null,null,'0',TIMESTAMP '2023-10-01 07:15:32.000',null,null)
  , (8,'d5@d','オークラ','オークラ','2','$2a$10$pYLegX5ywTgHXGnI7B.Jv.F.s6L3EKi6cDCXBnDLSWt5lRReT4bm6',null,'0',null,1,null,null,'0',null,null,null); 

-- 芸人情報
insert into c4cup.`comedian_profile`(id, user_id,member_num,create_at,update_at) values 
    (1,1,1,null,null)
  , (2,2,2,null,null)
  , (3,3,2,null,null)
  , (4,4,2,null,null);
-- 作家情報  
insert into c4cup.`composer_profile`(id, user_id,fee_type,fee,create_at,update_at) values 
    (1,5,1,100,null,null)
  , (2,6,2,100,null,null)
  , (3,7,2,100,null,null)
  , (4,8,2,100,null,null);

  SET FOREIGN_KEY_CHECKS = 1;
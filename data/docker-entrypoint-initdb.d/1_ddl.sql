-- テーブル削除
SET FOREIGN_KEY_CHECKS = 0;

-- 地域
insert into area (id, area) values (1, '北海道'),(2, '東北'),(3, '関東'),(4, '中部'),(5, '近畿'),(6, '中国'),(7, '四国'),(8, '九州');

-- 事務所
insert into office (id, office_name) values (1, '吉本興業'),(2, 'プロダクション人力舎'),(3, 'マセキ芸能社'),(4, '松竹芸能'),(5, 'アヴィラ'),(6, '浅井企画'),(7, 'ASH&Dコーポレーション'),(8, 'アミー・パーク'),(9, 'UMEDA芸能'),(10, 'FMG'),(11, 'MLクリエーション'),(12, '大川興業'),(13, '太田プロダクション'),(14, 'オフィス北野'),(15, 'オリジン・コーポレーション'),(16, 'お笑い集団ティーライズ'),(17, 'グレープカンパニー'),(18, 'ケイダッシュステージ'),(19, 'K-PRO'),(20, 'ザ・森東'),(21, 'サンミュージックプロダクション'),(22, 'SHUプロモーション'),(23, 'スパンキープロダクション'),(24, 'ソニー・ミュージックアーティスツ'),(25, 'タイタン'),(26, 'トゥインクル・コーポレーション'),(27, '徳間ジャパンコミュニケーションズ'),(28, 'どっかんプロ'),(29, 'トップ・カラー'),(30, 'ナチュラルエイト'),(31, 'ニュースタッフプロダクション'),(32, 'ノーリーズン'),(33, 'ファインステージ'),(34, 'プロデューサーハウスあ・うん'),(35, 'ホリプロ'),(36, 'ホリプロコム'),(37, '三木プロダクション'),(38, 'ワタナベエンターテインメント'),(39, 'ワハハ本舗'),(40, '無所属');

-- 芸風
insert into comedy_style (id, style_name) values (1, '漫才'),(2, 'コント'),(3, 'ギャグ'),(4, 'モノマネ'),(5, '歌ネタ'),(6, 'リズムネタ'),(7, 'その他');

-- 特殊スキル
insert into special_skill (id, special_skill_name) values (1, '動画編集'),(2, 'イラスト制作'),(3, '音源制作');

-- 利用者
insert into c4cup.`user`(id, user_address,user_name,user_name_kana,user_type,password,debut_dt,gender,office_id,area_id,self_introduction,profile_img_path,delete_flg,login_at,create_at,update_at) values 
    (1,'a@a','test','てすと','1','$2a$10$4.5qWU/J0IOj888EKpWr9.PoP6IF89AebM7lCCzCjoXwRvhssv7.C','2023-10-21','0',1,1,null,null,'0',TIMESTAMP '2023-09-27 12:56:28.000',null,null)
  , (2,'b@b','サメゾンビ','さめぞんび','1','$2a$10$VRUXCjV9CoaGli2PUTGGderirtno.5CA/QQlp3yhaDOXTp1eBRXKi','2023-10-21','0',1,1,null,null,'0',TIMESTAMP '2023-10-01 07:14:57.000',null,null)
  , (3,'c@c','ミルクボーイ','みるくぼーい','1','$2a$10$3BVoLnUhCi3ut9xRw82BHe4KgJTaRbJV4.Xfk5IgrztEFscc0iWrK','2023-10-21','0',1,1,null,null,'0',TIMESTAMP '2023-10-01 07:15:32.000',null,null)
  , (4,'d@d','マヂカルラブリー','まぢかるらぶりー','1','$2a$10$pYLegX5ywTgHXGnI7B.Jv.F.s6L3EKi6cDCXBnDLSWt5lRReT4bm6','2023-10-21','0',1,1,null,null,'0',null,null,null)
  ,(5,'a2@a','佐藤満春','さとうみつはる','2','$2a$10$4.5qWU/J0IOj888EKpWr9.PoP6IF89AebM7lCCzCjoXwRvhssv7.C','2023-10-21','0',1,1,null,null,'0',TIMESTAMP '2023-09-27 12:56:28.000',null,null)
  , (6,'b3@b','鈴木おさむ','すずきおさむ','2','$2a$10$VRUXCjV9CoaGli2PUTGGderirtno.5CA/QQlp3yhaDOXTp1eBRXKi','2023-10-21','0',1,1,null,null,'0',TIMESTAMP '2023-10-01 07:14:57.000',null,null)
  , (7,'c4@c','高須光聖','タカスミツヨシ','2','$2a$10$3BVoLnUhCi3ut9xRw82BHe4KgJTaRbJV4.Xfk5IgrztEFscc0iWrK','2023-10-21','0',1,1,null,null,'0',TIMESTAMP '2023-10-01 07:15:32.000',null,null)
  , (8,'d5@d','オークラ','オークラ','2','$2a$10$pYLegX5ywTgHXGnI7B.Jv.F.s6L3EKi6cDCXBnDLSWt5lRReT4bm6','2023-10-21','0',1,1,null,null,'0',null,null,null); 

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

-- 芸風
INSERT INTO c4cup.own_comedy_style (comedy_style_id,user_id,create_at,update_at) VALUES
	 (1,1,'2023-01-01 00:00:00','2023-01-01 00:00:00'),
	 (2,1,'2023-01-01 00:00:00','2023-01-01 00:00:00'),
	 (3,1,'2023-01-01 00:00:00','2023-01-01 00:00:00');

  SET FOREIGN_KEY_CHECKS = 1;
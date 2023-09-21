## Resourceクラスの返却方法

1. Resourceクラスを作成する。
2. 戻り値の型にApiResource<Resource>を設定する。メッセージのみの場合、Messagesクラスを設定
3. (メッセージがない場合は不要)_CmnControllerのgetMessageメソッドへメッセージコード、可変文字列を渡しメッセージを取得する
4. (メッセージがない場合は不要)getReturnMsgメソッドでMessagesクラスへ変換
5. ApiResource;のコンストラクタへ作成したResourceクラスとMessagesを設定する

## AwsUtilの利用方法
1. プロジェクトルートにcredentialsフォルダ作成
2. credentialsフォルダにcredentialsファイル作成
3. 松本にaccesskeyを尋ねる

## getter,setterの実装例
### 実装場所
controller→bean->req or res
### コメント実装例
```
/** ユーザID */
private int userId;



/**
  * ユーザIDを取得します。
  * @return ユーザID
  */
public int getUserId() {
    return userId;
}
/**
  * ユーザIDを設定します。
  * @param userId ユーザID
  */
public void setUserId(int userId) {
    this.userId = userId;
}

```

package com.c4ccup.laugh.controller.bean.req;

/**
 * ユーザ詳細Bean
 */
public class UserDetailBean {

    /** 送信ユーザID */
    private int sendUserId;
    /** 受信ユーザID */
    private int receiveUserId;
    /** マッチステータス */
    private int matchStatus;
    /** ユーザType */
    private int userType;


    /**
     * 送信ユーザIDを取得します。
     * @return ユーザID
     */
    public int getSendUserId() {
        return sendUserId;
    }
    /**
     * 送信ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }
    /**
     * 受信ユーザIDを取得します。
     * @return userType
     */
    public int getReceiveUserId() {
        return receiveUserId;
    }
    /**
     * 受信ユーザIDを設定します。
     * @param userType
     */
    public void setReceiveUserId(int receiveUserId) {
        this.receiveUserId = receiveUserId;
    }
    /**
     * マッチステータスを取得します。
     * @return matchStatus
     */
    public int getMatchStatus() {
        return matchStatus;
    }
    /**
     * マッチステータスを設定します。
     * @param matchStatus セットする matchStatus
     */
    public void setMatchStatus(int matchStatus) {
        this.matchStatus = matchStatus;
    }
    /**
     * ユーザTypeを取得します。
     * @return userType
     */
    public int getUserType() {
        return userType;
    }
    /**
     * ユーザTypeを設定します。
     * @param userType
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }
}

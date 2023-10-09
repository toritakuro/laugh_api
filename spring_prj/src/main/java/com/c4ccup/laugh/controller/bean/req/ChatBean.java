package com.c4ccup.laugh.controller.bean.req;

/**
 * チャットBean
 */
public class ChatBean {

    /** チャットルームID */
    private int chatRoomId;
    /** ユーザ種別 */
    private int userType;
    /** 送信相手ID */
    private int targetUserId;
    /** ユーザId */
    private int userId;
    /** メッセージ */
    private String chatMessage;



    /**
     * チャットルームIDを取得します。
     * @return チャットルームID
     */
    public int getChatRoomId() {
        return chatRoomId;
    }
    /**
     * チャットルームIDを設定します。
     * @param chatRoomId チャットルームID
     */
    public void setChatRoomId(int chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
    /**
     * ユーザ種別を取得します。
     * @return ユーザ種別
     */
    public int getUserType() {
        return userType;
    }
    /**
     * ユーザ種別を設定します。
     * @param userType ユーザ種別
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }
    /**
     * 送信相手IDを取得します。
     * @return 送信相手ID
     */
    public int getTargetUserId() {
        return targetUserId;
    }
    /**
     * 送信相手IDを設定します。
     * @param targetUserId 送信相手ID
     */
    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }
    /**
     * ユーザIdを取得します。
     * @return ユーザId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * ユーザIdを設定します。
     * @param userId ユーザId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getChatMessage() {
        return chatMessage;
    }
    /**
     * メッセージを設定します。
     * @param chatMessage メッセージ
     */
    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

}

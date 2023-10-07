package com.c4ccup.laugh.controller.bean.req;

/**
 * チャットBean
 */
public class ChatBean {

    /** チャットルームID */
    private int chatRoomId;
    /** ユーザ種別 */
    private int userType;
    /** 作家ID */
    private int userComposerId;
    /** 芸人ID */
    private int userComedianId;
    /** ユーザId */
    private int userId;
    /** メッセージ */
    private String chatMessasge;



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
     * 作家IDを取得します。
     * @return 作家ID
     */
    public int getUserComposerId() {
        return userComposerId;
    }
    /**
     * 作家IDを設定します。
     * @param userComposerId 作家ID
     */
    public void setUserComposerId(int userComposerId) {
        this.userComposerId = userComposerId;
    }
    /**
     * 芸人IDを取得します。
     * @return 芸人ID
     */
    public int getUserComedianId() {
        return userComedianId;
    }
    /**
     * 芸人IDを設定します。
     * @param userComedianId 芸人ID
     */
    public void setUserComedianId(int userComedianId) {
        this.userComedianId = userComedianId;
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
    public String getChatMessasge() {
        return chatMessasge;
    }
    /**
     * メッセージを設定します。
     * @param chatMessasge メッセージ
     */
    public void setChatMessasge(String chatMessasge) {
        this.chatMessasge = chatMessasge;
    }

}

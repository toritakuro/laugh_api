package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

/** chatドメインクラス */
public class Chat {

    /** チャットルームid */
    private int chatRoomId;
    /** チャットID */
    private int chatId;
    /** 芸人ID */
    private Integer userComedianId;
    /** 作家ID */
    private Integer userComposerId;
    /** 送信ユーザID */
    private int sendUserId;
    /** メッセージID */
    private String chatMessage;
    /** 作成日 */
    private LocalDateTime createAt;
    /** 芸人 */
    private User comedian;
    /** 作家 */
    private User composer;

    /**
     * チャットルームidを取得します。
     * @return チャットルームid
     */
    public int getChatRoomId() {
        return chatRoomId;
    }
    /**
     * チャットルームidを設定します。
     * @param chatRoomId チャットルームid
     */
    public void setChatRoomId(int chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
    /**
     * チャットIDを取得します。
     * @return チャットID
     */
    public int getChatId() {
        return chatId;
    }
    /**
     * チャットIDを設定します。
     * @param chatId チャットID
     */
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
    /**
     * 芸人IDを取得します。
     * @return 芸人ID
     */
    public Integer getUserComedianId() {
        return userComedianId;
    }
    /**
     * 芸人IDを設定します。
     * @param userComedianId 芸人ID
     */
    public void setUserComedianId(Integer userComedianId) {
        this.userComedianId = userComedianId;
    }
    /**
     * 作家IDを取得します。
     * @return 作家ID
     */
    public Integer getUserComposerId() {
        return userComposerId;
    }
    /**
     * 作家IDを設定します。
     * @param userComposerId 作家ID
     */
    public void setUserComposerId(Integer userComposerId) {
        this.userComposerId = userComposerId;
    }
    /**
     * 送信ユーザIDを取得します。
     * @return 送信ユーザID
     */
    public int getSendUserId() {
        return sendUserId;
    }
    /**
     * 送信ユーザIDを設定します。
     * @param sendUserId 送信ユーザID
     */
    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }
    /**
     * メッセージIDを取得します。
     * @return メッセージID
     */
    public String getChatMessage() {
        return chatMessage;
    }
    /**
     * メッセージIDを設定します。
     * @param chatMessage メッセージID
     */
    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }
    /**
     * 作成日を取得します。
     * @return 作成日
     */
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    /**
     * 作成日を設定します。
     * @param createAt 作成日
     */
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    /**
     * 芸人を取得します。
     * @return 芸人
     */
    public User getComedian() {
        return comedian;
    }
    /**
     * 芸人を設定します。
     * @param comedian 芸人
     */
    public void setComedian(User comedian) {
        this.comedian = comedian;
    }
    /**
     * 作家を取得します。
     * @return 作家
     */
    public User getComposer() {
        return composer;
    }
    /**
     * 作家を設定します。
     * @param composer 作家
     */
    public void setComposer(User composer) {
        this.composer = composer;
    }

}

package com.c4ccup.laugh.controller.bean.res;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ChatResource {

    /** チャットルームID */
    private Integer chatRoomId;
    /** チャットID */
    private Integer chatId;
    /** ターゲットユーザーID */
    private Integer targetUserId;
    /** 相手名 */
    private String name;
    /** 画像 */
    private String img;
    /** メッセージ */
    private String message;
    /** 未読数 */
    private int unreadCount;
    /** 送信日 */
    private String sendAt;
    /** 送信時間 */
    private String sendTime;
    /** 自分が送信したメッセージ */
    private Boolean isMyMessage;

    /**
     * チャットルームIDを取得します。
     * 
     * @return チャットルームID
     */
    public Integer getChatRoomId() {
        return chatRoomId;
    }

    /**
     * チャットルームIDを設定します。
     * 
     * @param chatRoomId チャットルームID
     */
    public void setChatRoomId(Integer chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    /**
     * チャットIDを取得します。
     * 
     * @return チャットID
     */
    public Integer getChatId() {
        return chatId;
    }

    /**
     * チャットIDを設定します。
     * 
     * @param chatId チャットID
     */
    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    /**
     * ターゲットユーザーIDを取得します。
     * @return ターゲットユーザーID
     */
    public Integer getTargetUserId() {
        return targetUserId;
    }

    /**
     * ターゲットユーザーIDを設定します。
     * @param targetUserId ターゲットユーザーID
     */
    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    /**
     * 相手名を取得します。
     * 
     * @return 相手名
     */
    public String getName() {
        return name;
    }

    /**
     * 相手名を設定します。
     * 
     * @param name 相手名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 画像を取得します。
     * 
     * @return 画像
     */
    public String getImg() {
        return img;
    }

    /**
     * 画像を設定します。
     * 
     * @param img 画像
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * メッセージを取得します。
     * 
     * @return メッセージ
     */
    public String getMessage() {
        return message;
    }

    /**
     * メッセージを設定します。
     * 
     * @param message メッセージ
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 未読数を取得します。
     * @return 未読数
     */
    public int getUnreadCount() {
        return unreadCount;
    }

    /**
     * 未読数を設定します。
     * @param unreadCount 未読数
     */
    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    /**
     * 送信日を取得します。
     * 
     * @return 送信日
     */
    public String getSendAt() {
        return sendAt;
    }

    /**
     * 送信日を設定します。
     * 
     * @param sendAt 送信日
     */
    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }

    /**
     * 送信時間を取得します。
     * 
     * @return 送信時間
     */
    public String getSendTime() {
        return sendTime;
    }

    /**
     * 送信時間を設定します。
     * 
     * @param sendTime 送信時間
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 自分が送信したメッセージを取得します。
     * 
     * @return 自分が送信したメッセージ
     */
    public Boolean getIsMyMessage() {
        return isMyMessage;
    }

    /**
     * 自分が送信したメッセージを設定します。
     * 
     * @param isMyMessage 自分が送信したメッセージ
     */
    public void setIsMyMessage(Boolean isMyMessage) {
        this.isMyMessage = isMyMessage;
    }

}

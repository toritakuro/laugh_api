package com.c4ccup.laugh.controller.bean.res;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ChatResource {

    /** チャットルームID */
    private int chatRoomId;
    /** チャットID */
    private Integer chatId;
    /** 相手名 */
    private String name;
    /** 画像 */
    private String img;
    /** メッセージ */
    private String message;
    /** 送信日 */
    private String sendAt;


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
     * チャットIDを取得します。
     * @return チャットID
     */
    public Integer getChatId() {
        return chatId;
    }
    /**
     * チャットIDを設定します。
     * @param chatId チャットID
     */
    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }
    /**
     * 相手名を取得します。
     * @return 相手名
     */
    public String getName() {
        return name;
    }
    /**
     * 相手名を設定します。
     * @param name 相手名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 画像を取得します。
     * @return 画像
     */
    public String getImg() {
        return img;
    }
    /**
     * 画像を設定します。
     * @param img 画像
     */
    public void setImg(String img) {
        this.img = img;
    }
    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getMessage() {
        return message;
    }
    /**
     * メッセージを設定します。
     * @param message メッセージ
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * 送信日を取得します。
     * @return 送信日
     */
    public String getSendAt() {
        return sendAt;
    }
    /**
     * 送信日を設定します。
     * @param sendAt 送信日
     */
    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }

}

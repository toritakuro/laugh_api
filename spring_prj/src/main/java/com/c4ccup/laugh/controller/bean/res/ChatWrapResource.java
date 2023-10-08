package com.c4ccup.laugh.controller.bean.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ChatWrapResource {

    /** チャットルームID */
    private int chatRoomId;
    /** チャット */
    private List<ChatResource> chatList;



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
     * チャットを取得します。
     * @return チャット
     */
    public List<ChatResource> getChatList() {
        return chatList;
    }
    /**
     * チャットを設定します。
     * @param chatList チャット
     */
    public void setChatList(List<ChatResource> chatList) {
        this.chatList = chatList;
    }

}

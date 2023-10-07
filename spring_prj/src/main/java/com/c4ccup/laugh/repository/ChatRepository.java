package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.c4ccup.laugh.domain.Chat;

@Mapper
public interface ChatRepository {

    /**
     * チャット一覧を取得する
     * @param chat
     * @return List<Chat>
     */
    public List<Chat> findChatList(Chat chat);

    /**
     * チャット詳細を取得する
     * @param chat
     * @return List<Chat>
     */
    public List<Chat> findChatDetail(Chat chat);

    /**
     * チャットルームを作成する
     * @param chat
     * @return int
     */
    public int createChatRoom(Chat chat);

    /**
     * チャットルームを送信する
     * @param chat
     * @return int
     */
    public void sendChat(Chat chat);

}

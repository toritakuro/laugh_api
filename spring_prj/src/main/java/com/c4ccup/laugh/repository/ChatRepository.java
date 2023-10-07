package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.c4ccup.laugh.domain.Chat;

@Mapper
public interface ChatRepository {

    /**
     * チャットリストを取得する
     *@param demoBean DemoBean型の要素
     *@return Demo
     */
    public List<Chat> findChatList(Chat chat);

}

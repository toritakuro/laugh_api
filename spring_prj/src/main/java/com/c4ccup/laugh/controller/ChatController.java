package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.ChatBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.ChatResource;
import com.c4ccup.laugh.domain.Chat;
import com.c4ccup.laugh.repository.ChatRepository;
import com.c4ccup.laugh.util.Util;
import com.c4ccup.laugh.util.AppConst.DateFormatEnum;

/**
 * チャットControllerクラス
 */
@RestController
@RequestMapping(value = "chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<ChatResource>>> chatList(@ModelAttribute ChatBean bean) {
        // チャットの一覧を送信日が新しい順番に取得
        Chat chat = new Chat();
        int selfId;
        if (bean.getUserComposerId() != null) {
            selfId = bean.getUserComposerId();
            chat.setUserComposerId(bean.getUserComposerId());
        } else {
            selfId = bean.getUserComedianId();
            chat.setUserComedianId(bean.getUserComedianId());
        }
        List<Chat> chatList = chatRepository.findChatList(chat);

        List<ChatResource> results = new ArrayList<>();
        for (Chat c : chatList) {
            ChatResource chatResource = new ChatResource();
            chatResource.setChatRoomId(c.getChatRoomId());
            chatResource.setMessage(c.getChatMessage());
            if (selfId == c.getComedian().getId()) {
                // 自分が芸人の場合、作家の名前を表示
                chatResource.setName(c.getComposer().getUserName());
            } else {
                // 自分が作家の場合、芸人の名前を表示
                chatResource.setName(c.getComedian().getUserName());
            }
            chatResource.setSendAt(Util.formatLocalDateTime(c.getCreateAt(), DateFormatEnum.SLASH_YMD));
            // TODO 画像
            results.add(chatResource);
        }

        return ResponseEntity.ok(new ApiResource<>(results));
    }

}

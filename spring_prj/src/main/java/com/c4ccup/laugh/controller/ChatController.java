package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.ChatBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.ChatResource;
import com.c4ccup.laugh.controller.bean.res.ChatWrapResource;
import com.c4ccup.laugh.domain.Chat;
import com.c4ccup.laugh.repository.ChatRepository;
import com.c4ccup.laugh.util.Util;
import com.c4ccup.laugh.util.AppConst.DateFormatEnum;
import com.c4ccup.laugh.util.AppConst.UserEnum;

/**
 * チャットControllerクラス
 */
@RestController
@RequestMapping(value = "chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    /**
     * チャット一覧を送信時間順に返却する
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<ChatResource>>> chatList(@ModelAttribute ChatBean request) {
        Chat chat = new Chat();
        boolean isComedian = request.getUserType() == UserEnum.COMEDIAN.getId();

        if (isComedian) { chat.setUserComedianId(request.getUserId()); }
        else { chat.setUserComposerId(request.getUserId()); }

        // チャット一覧取得
        List<Chat> chatList = chatRepository.findChatList(chat);

        List<ChatResource> results = new ArrayList<>();
        for (Chat c : chatList) {
            ChatResource chatResource = new ChatResource();
            chatResource.setChatRoomId(c.getChatRoomId());
            chatResource.setMessage(c.getChatMessage());
            if (isComedian) {
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

    /**
     * マッチング相手とのチャット一覧を返却する
     * @param request
     * @return
     */
    @RequestMapping(path = "/detail",  method = RequestMethod.GET)
    public ResponseEntity<ApiResource<ChatWrapResource>> chatDetailList(@ModelAttribute ChatBean request) {
        Chat chat = new Chat();
        chat.setChatRoomId(request.getChatRoomId());
        List<Chat> chatList = chatRepository.findChatDetail(chat);

        List<ChatResource> results = new ArrayList<>();
        for (Chat c : chatList) {
            ChatResource chatResource = new ChatResource();
            chatResource.setMessage(Util.changeRCtoBR(c.getChatMessage()));
            chatResource.setIsMyMessage(request.getUserId() == c.getSendUserId());
            chatResource.setSendAt(Util.formatLocalDateTime(c.getCreateAt(), DateFormatEnum.SLASH_YMD));
            chatResource.setSendTime(Util.formatLocalDateTime(c.getCreateAt(), DateFormatEnum.TIME));
            results.add(chatResource);
        }

        ChatWrapResource resource = new ChatWrapResource();
        if (results.size() >= 1) {
            resource.setChatList(results);
            resource.setChatRoomId(chatList.get(0).getChatRoomId());
        }

        return ResponseEntity.ok(new ApiResource<>(resource));
    }

    /**
     * メッセージを送信する
     * @param request
     */
    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@RequestBody ChatBean request) {
        // 初回のメッセージの場合、ルーム作成
        Chat chat = new Chat();
        chat.setChatRoomId(request.getChatRoomId());
        if (request.getChatRoomId() == 0) {
            if (request.getUserType() == UserEnum.COMEDIAN.getId()) {
                chat.setUserComedianId(request.getUserId());
                chat.setUserComposerId(request.getTargetUserId());
            } else {
                chat.setUserComedianId(request.getTargetUserId());
                chat.setUserComposerId(request.getUserId());
            }
            chatRepository.createChatRoom(chat);
        }

        // メッセージ作成
        chat.setSendUserId(request.getUserId());
        chat.setChatMessage(request.getChatMessage());
        chatRepository.sendChat(chat);
    }

}

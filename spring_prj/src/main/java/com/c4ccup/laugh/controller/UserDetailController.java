package com.c4ccup.laugh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.controller.bean.req.UserDetailBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.OogiriAnswerResources;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.Chat;
import com.c4ccup.laugh.domain.Laugh;
import com.c4ccup.laugh.domain.Oogiri;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.ChatRepository;
import com.c4ccup.laugh.repository.MatchStatusRepository;
import com.c4ccup.laugh.repository.MyPageRepository;
import com.c4ccup.laugh.repository.OogiriRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.EnumConst.MatchStatus;

/**
 * ユーザー詳細 Controllerクラス
 */
@RequestMapping(value = "userDetail")
@RestController
public class UserDetailController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OogiriRepository oogiriRepository;
    @Autowired
    private MatchStatusRepository matchStatusRepository;
    @Autowired
    private MyPageRepository mypageRepository;
    @Autowired
    private ChatRepository chatRepository;

    /**
     * ユーザー情報を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<UserResource>> init(UserDetailBean bean) {
        int userType = bean.getUserType();
        User user = new User();
        if (userType == UserEnum.COMEDIAN.getId()) {
            user = userRepository.getComedian(bean.getReceiveUserId());
        } else {
            user = userRepository.getComposer(bean.getReceiveUserId());
        }
        // 相手とのマッチングステータスを取得する
        Laugh matchStatus = mypageRepository.selectMatchStatus(bean.getSendUserId(), bean.getReceiveUserId());
        // データがあった場合
        if (matchStatus != null) {
            user.setMatchStatus(matchStatus.getStatus());
        } 
        
        return ResponseEntity.ok(new ApiResource<>(new UserResource(user)));
    }

    /**
     * ユーザーの大喜利回答一覧を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(path = "/oogiriAnswer", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<OogiriAnswerResources>> oogiriAnswer(MyPageBean bean) {
        List<Oogiri> oogiriList  = oogiriRepository.getAnswerByUserId(bean);
        OogiriAnswerResources res = new OogiriAnswerResources();
        res.setAnswerList(oogiriList);
        return ResponseEntity.ok(new ApiResource<>(res));
    }

    /**
     * マッチステータス登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/regMatch", method = RequestMethod.POST)
    public void regMatch(@RequestBody UserDetailBean bean) {
        int matchStatus = bean.getMatchStatus();
        Chat chat = new Chat();
        if (bean.getUserType() == UserEnum.COMEDIAN.getId()) {
            chat.setUserComedianId(bean.getSendUserId());
            chat.setUserComposerId(bean.getReceiveUserId());
        } else {
            chat.setUserComedianId(bean.getReceiveUserId());
            chat.setUserComposerId(bean.getSendUserId());
        }
        // 未マッチ
        if (matchStatus == MatchStatus.PRE_MATCH.getStatus()) {
            matchStatusRepository.regMatchStatus(bean);
        }
        // マッチ
        if (matchStatus == MatchStatus.MATCH.getStatus()) {
            matchStatusRepository.updateMatchStatus(bean);
            chatRepository.createChatRoom(chat);
        }
        // スーパーラフ
        if (matchStatus == MatchStatus.SUPER_LAUGHT.getStatus()) {
            matchStatusRepository.regMatchStatus(bean);
            chatRepository.createChatRoom(chat);
        }
        // キャンセル
        if (matchStatus == MatchStatus.CANCEL.getStatus()) {
            matchStatusRepository.updateMatchStatus(bean);
            Chat chatRoomId = chatRepository.findChatRoom(chat);
            chatRepository.deleteChatRoom(chatRoomId.getChatRoomId());
            chatRepository.deleteChatDetail(chatRoomId.getChatRoomId());
        }
    }
}

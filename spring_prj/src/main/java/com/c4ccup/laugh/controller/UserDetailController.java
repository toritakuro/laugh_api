package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.controller.bean.req.NoticeBean;
import com.c4ccup.laugh.controller.bean.req.UserDetailBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.ContentResources;
import com.c4ccup.laugh.controller.bean.res.OogiriAnswerResources;
import com.c4ccup.laugh.controller.bean.res.OogiriResources;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.Chat;
import com.c4ccup.laugh.domain.Content;
import com.c4ccup.laugh.domain.Laugh;
import com.c4ccup.laugh.domain.Oogiri;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.ChatRepository;
import com.c4ccup.laugh.repository.MatchStatusRepository;
import com.c4ccup.laugh.repository.MyPageRepository;
import com.c4ccup.laugh.repository.OogiriRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.NoticeType;
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
    @Autowired
    private NoticeController noticeController;

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
        Laugh matchStatus = mypageRepository.selectMatchStatus(bean);

        // データがあった場合
        if (matchStatus != null) {
            // 送信者が自分の場合
            if (matchStatus.getSendUserId() == bean.getSendUserId()
             && matchStatus.getStatus() == MatchStatus.PRE_MATCH.getStatus()) {
                // ボタン非表示のために99をセット
                user.setMatchStatus(MatchStatus.CANCEL.getStatus());
            } else {
                user.setMatchStatus(matchStatus.getStatus());
            }
        }

        return ResponseEntity.ok(new ApiResource<>(new UserResource(user)));
    }

    /**
     * ユーザーの大喜利回答一覧を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(path = "/oogiriAnswer", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<OogiriResources>>> oogiriAnswer(MyPageBean bean) {
        List<Oogiri> oogiriList = oogiriRepository.getAnswerByUserId(bean);
        int prevId = 0;
        List<OogiriResources> oogiriResultList = new ArrayList<>();
        OogiriResources o = new OogiriResources();

        for (Oogiri oogiri : oogiriList) {
           if (oogiri.getThemeId() != prevId) {
               o = new OogiriResources();
               o.setThemeContent(oogiri.getThemeContent());
               o.setAnswers(new ArrayList<OogiriAnswerResources>());
               oogiriResultList.add(o);
           }
           OogiriAnswerResources answer = new OogiriAnswerResources();

           answer.setAnswerContent(oogiri.getAnswerContent());
           answer.setTotalNum(oogiri.getReactionNum());
           answer.setGoodNum(oogiri.getGoodNum());
           answer.setVeryGoodNum(oogiri.getVeryGoodNum());
           answer.setBadNum(oogiri.getBadNum());
           // お題に追加する
           o.getAnswers().add(answer);

           prevId = oogiri.getThemeId();
        }

        return ResponseEntity.ok(new ApiResource<>(oogiriResultList));
    }

    /**
     * ユーザーの投稿一覧を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(path = "/content", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<ContentResources>>> getContent(MyPageBean bean) {
        List<ContentResources> contentResList = new ArrayList<>();
        List<Content> contentList = mypageRepository.selectContent(bean);
        // 投稿の情報をセット
        for (Content content : contentList) {
            ContentResources res = new ContentResources(content);
            contentResList.add(res);
        }
        return ResponseEntity.ok(new ApiResource<>(contentResList));
    }

    /**
     * マッチステータス登録
     *
     * @param request
     * @return
     */
    @RequestMapping(path = "/match", method = RequestMethod.POST)
    public void match(@RequestBody UserDetailBean bean) {
        int matchStatus = bean.getMatchStatus();
        
        // chat作成の情報セット
        Chat chat = new Chat();
        if (bean.getUserType() == UserEnum.COMEDIAN.getId()) {
            chat.setUserComedianId(bean.getSendUserId());
            chat.setUserComposerId(bean.getReceiveUserId());
        } else {
            chat.setUserComedianId(bean.getReceiveUserId());
            chat.setUserComposerId(bean.getSendUserId());
        }
        
        // お知らせ作成の情報セット
        NoticeBean noticeBean = new NoticeBean();
        noticeBean.setUserIdFrom(bean.getSendUserId());
        noticeBean.setUserId(bean.getReceiveUserId());
        noticeBean.setTargetId(bean.getSendUserId());
        
        // ラフ送信
        if (matchStatus == MatchStatus.PRE_MATCH.getStatus()) {
            matchStatusRepository.regMatchStatus(bean);
            noticeBean.setTargetType(NoticeType.LAUGH.getType());
            noticeController.createNotice(noticeBean);
        }
        // マッチ
        if (matchStatus == MatchStatus.MATCH.getStatus()) {
            matchStatusRepository.updateMatchStatus(bean);
            chatRepository.createChatRoom(chat);
            noticeBean.setTargetType(NoticeType.MATCH.getType());
            noticeController.createNotice(noticeBean);
        }
        // スーパーラフ送信
        if (matchStatus == MatchStatus.SUPER_LAUGHT.getStatus()) {
            matchStatusRepository.regMatchStatus(bean);
            chatRepository.createChatRoom(chat);
            noticeBean.setTargetType(NoticeType.MATCH.getType());
            noticeController.createNotice(noticeBean);
        }
        // マッチ解消
        if (matchStatus == MatchStatus.CANCEL.getStatus()) {
            matchStatusRepository.updateMatchStatus(bean);
            Chat chatRoomId = chatRepository.findChatRoom(chat);
            chatRepository.deleteChatRoom(chatRoomId.getChatRoomId());
            chatRepository.deleteChatDetail(chatRoomId.getChatRoomId());
        }
    }
}

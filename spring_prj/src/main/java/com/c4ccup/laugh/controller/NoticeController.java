package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.NoticeBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.NoticeResource;
import com.c4ccup.laugh.domain.Notice;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.NoticeRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.NoticeType;

/**
 * お知らせ Controllerクラス
 */
@RequestMapping(value = "notice")
@RestController
public class NoticeController {

    @Autowired
    private NoticeRepository repository;
    @Autowired
    private UserRepository userRepository;

    /**
     * ログイン情報を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<NoticeResource>>> notice(NoticeBean bean) {
        List<Notice> noticeList = repository.findById(bean.getUserId());
        List<NoticeResource> list = new ArrayList<>();
        for (Notice notice : noticeList) {
            list.add(new NoticeResource(notice)) ;
        }
        return ResponseEntity.ok(new ApiResource<>(list));
    }

    /**
     * お知らせ既読処理
     * @param bean
     */
    @RequestMapping(method = RequestMethod.POST)
    public void read(@RequestBody NoticeBean bean) {
        repository.read(bean.getId());
    }

    /**
     * 各機能から呼び出される(UserIdFromはお知らせ送信ユーザ、userIdはお知らせ受取ユーザ)
     * @param bean
     */
    public void createNotice(NoticeBean bean) {
        String message = null;
        User targetUser = userRepository.findById(bean.getUserIdFrom());
        String userName = targetUser.getUserName() + "さん";
        if (bean.getTargetType() == NoticeType.LAUGH.getType()) {
            message = userName + "からLaughが届いています。";
        }
        else if (bean.getTargetType() == NoticeType.MESSAGE.getType()) {
            message = userName + "からメッセージが届いています。";
        }
        else if (bean.getTargetType() == NoticeType.MATCH.getType()) {
            message = userName + "とマッチしました。";
        }
        Notice notice = new Notice();
        notice.setTargetUserId(bean.getUserId());
        notice.setTargetType(bean.getTargetType());
        notice.setTargetId(bean.getTargetId());
        notice.setMessage(message);

        repository.create(notice);
    }


}

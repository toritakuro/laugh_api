package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.TopBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;


/**
 * Topクラス
 *
 */
@RequestMapping(value = "top")
@RestController
public class TopController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<UserResource>>> init(TopBean bean) {

        List<UserResource> topUserList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        int loginUserType = bean.getUserType();

        // ユーザーの一覧を取得
        if (loginUserType == UserEnum.COMEDIAN.getId()) {
            // 作家一覧を取得
            userList = userRepository.getComposerList(UserEnum.COMPOSER.getId());
        } else {
            // 芸人一覧を取得
            userList = userRepository.getComedianList(UserEnum.COMEDIAN.getId());
        }
        // ユーザーの情報をセット
        for (User user : userList) {
            UserResource users = new UserResource(user);
            topUserList.add(users);
        }
        return ResponseEntity.ok(new ApiResource<>(topUserList));
    }
}

package com.c4ccup.laugh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.UserDetailBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;

/**
 * ユーザー詳細 Controllerクラス
 */
@RequestMapping(value = "userDetail")
@RestController
public class UserDetailController {

    @Autowired
    private UserRepository userRepository;

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
            user = userRepository.getComedian(bean.getUserId());
        } else {
            user = userRepository.getComposer(bean.getUserId());
        }
        
        return ResponseEntity.ok(new ApiResource<>(new UserResource(user)));
    }

}

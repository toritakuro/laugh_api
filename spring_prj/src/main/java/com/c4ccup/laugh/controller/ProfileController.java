package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.repository.UserRepository;

/**
 * CRUDを操作するProfileクラス
 *
 */
@RequestMapping(value = "profile")
@RestController
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新規登録するメソッド
     * @param id
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserBean userBean) {
        // TODO：共通クラスに記載？
        userBean.setLoginAt(LocalDateTime.now(ZoneId.of("Asia/Tokyo")));
        userBean.setCreateAt(LocalDateTime.now(ZoneId.of("Asia/Tokyo")));
        userBean.setUpdateAt(LocalDateTime.now(ZoneId.of("Asia/Tokyo")));

        //debutDtをセット
        Calendar cal = Calendar.getInstance();
        cal.set(userBean.getDebutYear(), userBean.getDebutMonth() - 1, 1);
        userBean.setDebutDt(cal);

        // ユーザーの登録
        userRepository.register(userBean);

        // 登録したユーザーのuserId取得
        int userId = userRepository.getMaxUserId();
        userBean.setUserId(userId);

        // 作家プロフィールの登録
        if(userBean.getUserType() == 1) {
            userRepository.registerComposer(userBean);
        }

        // 芸人プロフィールの登録
        if(userBean.getUserType() == 2) {
            userRepository.registerComedian(userBean);
        }

        // 得意分野の登録
        if (userBean.getComedyStyleIdList() != null) {
            for(int comedyStyleId: userBean.getComedyStyleIdList()) {
                userBean.setComedyStyleId(comedyStyleId);
                userRepository.registerOwnComedyStyle(userBean);
            }
        }

        // 特殊スキルの登録
        if (userBean.getSpecialSkillIdList() != null) {
            String tmp_another_skill = userBean.getAnotherSkill();
            for(int specialSkillId: userBean.getSpecialSkillIdList()) {
                userBean.setSpecialSkillId(specialSkillId);
                String another_skill = specialSkillId == 3 ? tmp_another_skill : "";
                userBean.setAnotherSkill(another_skill);
                userRepository.registerOwnSpecialSkill(userBean);
            }
        }
    }





}

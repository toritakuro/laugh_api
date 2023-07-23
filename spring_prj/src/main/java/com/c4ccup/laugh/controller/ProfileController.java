package com.c4ccup.laugh.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.AppConst.specialSkillEnum;
import com.c4ccup.laugh.util.AwsSesUtil;

/**
 * CRUDを操作するProfileクラス
 *
 */
@RequestMapping(value = "profile")
@RestController
public class ProfileController {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AwsSesUtil awsSesUtil;

    /**
     * 新規登録するメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserBean userBean) {

//        awsSesUtil.send("s.kunisu@c4c.co.jp", "test", "<h1>test</h1><p>aaa</p>");

        //debutDtをセット
        Calendar cal = Calendar.getInstance();
        cal.set(userBean.getDebutYear(), userBean.getDebutMonth() - 1, 1);
        userBean.setDebutDt(cal);

        // ユーザーを登録し、採番されたidを取得する
        int registerUserId = userRepository.register(userBean);

        // 登録したユーザーのuserId取得
        userBean.setUserId(registerUserId);

        // 作家プロフィールの登録
        if(userBean.getUserType() == UserEnum.COMPOSER.getId()) {
            userRepository.registerComposer(userBean);
        }

        // 芸人プロフィールの登録
        if(userBean.getUserType() == UserEnum.COMEDIAN.getId()) {
            userRepository.registerComedian(userBean);
        }

        // 得意分野の登録
        if (userBean.getComedyStyleIdList() != null) {
            for(int comedyStyleId: userBean.getComedyStyleIdList()) {
                userBean.setComedyStyleId(comedyStyleId);
                userRepository.registerOwnComedyStyle(userBean);
            }
        }

        // 特殊スキルの登録(作家のみ)
        if (userBean.getUserType() == UserEnum.COMPOSER.getId() && userBean.getSpecialSkillIdList() != null) {
            String tmp_another_skill = userBean.getAnotherSkill();
            for(int specialSkillId: userBean.getSpecialSkillIdList()) {
                userBean.setSpecialSkillId(specialSkillId);
                // 「その他」選択されてたらanother_skillカラムに内容登録
                String another_skill = specialSkillId == specialSkillEnum.OTHERS.getId() ? tmp_another_skill : "";
                userBean.setAnotherSkill(another_skill);
                userRepository.registerOwnSpecialSkill(userBean);
            }
        }
    }





}

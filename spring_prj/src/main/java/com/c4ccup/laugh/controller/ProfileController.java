package com.c4ccup.laugh.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.AwsSesUtil;
import com.c4ccup.laugh.util.PropBean;

/**
 * CRUDを操作するProfileクラス
 *
 */
@RequestMapping(value = "profile")
@RestController
public class ProfileController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AwsSesUtil awsSesUtil;


    /**
     * メールを送信するメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/init", method = RequestMethod.POST)
    public void init(@RequestBody PropBean propBean) {
        String userMailAddress = propBean.getEmail();
        String Title = "Laughの登録";
        String Text = "<p>以下のURLから登録をお願いします。</p><br>"
                     + "http://localhost:3000/profile/register/"
                     + propBean.getEmail().replace(".", "+");
        awsSesUtil.send(userMailAddress, Title, Text);
    }


    /**
     * 新規登録するメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserBean userBean) {

        //debutDtをセット
        LocalDate debutDt = LocalDate.of(userBean.getDebutYear(), userBean.getDebutMonth(), 1);
        userBean.setDebutDt(debutDt);

        // ユーザーをuserテーブルに登録する。
        userRepository.register(userBean);

        // 採番されたidを取得しregisterUserIdに入れる
        int registerUserId = userBean.getId();

        // 登録したユーザーのuserIdをセットしておく
        userBean.setUserId(registerUserId);

        // 作家プロフィールの登録
        if(userBean.getUserType() == UserEnum.COMPOSER.getId()) {
            userRepository.registerComposer(userBean);
        }

        // 芸人プロフィールの登録
        if(userBean.getUserType() == UserEnum.COMEDIAN.getId()) {
            userRepository.registerComedian(userBean);
        }

        // 得意分野の登録(作家・芸人どちらも)
        if (userBean.getComedyStyleIdList() != null) {
            for(int comedyStyleId: userBean.getComedyStyleIdList()) {
                userBean.setComedyStyleId(comedyStyleId);
                userRepository.registerOwnComedyStyle(userBean);
            }
        }

        // 特殊スキルの登録(作家のみ)
        if (userBean.getUserType() == UserEnum.COMPOSER.getId() && userBean.getSpecialSkillIdList() != null) {
            List<UserBean> userBeanList = new ArrayList<>();
            for(int specialSkillId: userBean.getSpecialSkillIdList()) {
                UserBean user = new UserBean();
                user.setUserId(registerUserId);
                user.setSpecialSkillId(specialSkillId);
                userBeanList.add(user);
            }

            // 「その他」で自由入力された内容は、specialSkillId = nullで登録する
            if(!userBean.getAnotherSkill().isEmpty()) {
                UserBean user = new UserBean();
                user.setUserId(registerUserId);
                user.setAnotherSkill(userBean.getAnotherSkill());
                userBeanList.add(user);
            }
            userRepository.registerOwnSpecialSkill(userBeanList);
        }
    }


    /**
     * 編集画面を返すメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/editInit", method = RequestMethod.GET)
    public ResponseEntity<User> editInit(@RequestBody int userId) {
        User user = userRepository.findById(1);
        return ResponseEntity.ok(user);
    }


}

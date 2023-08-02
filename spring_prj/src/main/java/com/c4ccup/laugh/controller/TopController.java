package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.domain.OwnComedyStyle;
import com.c4ccup.laugh.domain.OwnSpecialSkill;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.OwnComedyStyleRepository;
import com.c4ccup.laugh.repository.OwnSpecialSkillRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.UserTypeEnum;


/**
 * Topクラス
 *
 */
@RequestMapping(value = "top")
@RestController
public class TopController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OwnSpecialSkillRepository ownSpecialSkillRepository;
    @Autowired
    private OwnComedyStyleRepository ownComedyStyleRepository;

    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> init() {
        
        UserBean userBean = new UserBean();
        userBean.setUserType(UserTypeEnum.COMPOSER.getUserType());
//        userBean.setUserType(UserTypeEnum.COMEDIAN.getUserType());
        
        List<UserBean> topUserList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<OwnComedyStyle> ownComedyStyleList = new ArrayList<>();
        List<OwnSpecialSkill> ownSpecialSkillList = new ArrayList<>();
        
        // 芸風・得意分野のリストを取得
        ownComedyStyleList = ownComedyStyleRepository.getOwnComedyStyleList();
        // 作家の情報を取得
        if (userBean.getUserType() == UserTypeEnum.COMPOSER.getUserType()) {
            // 作家リストを取得
            userList = userRepository.getComposerList(userBean);
            // 特殊スキルリストを取得
            ownSpecialSkillList = ownSpecialSkillRepository.getOwnSpecialSkillList();
            // 取得した値を表示用にセット
            for (User user : userList) {
                // 作家・芸人共通処理
                UserBean users = new UserBean(user);
                this.setComedyInfo(users, ownComedyStyleList);
                
                // 作家専用処理
                // スペシャルスキル
                List<Integer> specialSkillId = new ArrayList<>();
                List<String> specialSkillName = new ArrayList<>();
                for (OwnSpecialSkill ownSpecialSkill : ownSpecialSkillList) {
                    if (users.getId() == ownSpecialSkill.getUserId()) {
                        specialSkillId.add(ownSpecialSkill.getSpecialSkillId().getId());
                        if (ownSpecialSkill.getAnotherSkillName() == null) {
                            specialSkillName.add(ownSpecialSkill.getSpecialSkillId().getSpecialSkillName());
                        } else {
                            specialSkillName.add(ownSpecialSkill.getAnotherSkillName());
                        }
                    }
                }
                users.setSkillId(specialSkillId);
                users.setSkillName(specialSkillName);
                users.setFeeType(user.getComposerProfile().getFeeType());
                users.setFee(user.getComposerProfile().getFee());
                
                topUserList.add(users);
            }
        } else {
            // 芸人の情報を取得
            userList = userRepository.getComedianList(userBean);
            for (User user : userList) {
                UserBean users = new UserBean(user);
                this.setComedyInfo(users, ownComedyStyleList);
                
                // 芸人専用処理
                // 活動人数
                users.setMemberNum(user.getComedianProfile().getMemberNum());
                
                topUserList.add(users);
            }
        }
        
        return ResponseEntity.ok(topUserList);
    }

    /**
     * 得意分野、芸風のセット処理  作家・芸人共通
     * @param users
     * @param ownComedyStyleList
     */
    private void setComedyInfo(UserBean users, List<OwnComedyStyle> ownComedyStyleList) {
        
        List<Integer> comedyStyleId = new ArrayList<>();
        List<String> comedyStyleName = new ArrayList<>();
        for (OwnComedyStyle ownComedyStyle : ownComedyStyleList) {
            if (users.getId() == ownComedyStyle.getUserId()) {
                comedyStyleId.add(ownComedyStyle.getComedyStyleId().getId());
                comedyStyleName.add(ownComedyStyle.getComedyStyleId().getStyleName());
            }
        }
        users.setComedyStyleId(comedyStyleId);
        users.setComedyStyleName(comedyStyleName);
    }
}

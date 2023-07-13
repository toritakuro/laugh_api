package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.TopBean;
import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.domain.Area;
import com.c4ccup.laugh.domain.Comedian;
import com.c4ccup.laugh.domain.ComedyStyle;
import com.c4ccup.laugh.domain.Composer;
import com.c4ccup.laugh.domain.Office;
import com.c4ccup.laugh.domain.OwnComedyStyle;
import com.c4ccup.laugh.domain.OwnSpecialSkill;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.domain.UserTypeEnum;
import com.c4ccup.laugh.repository.ComedianRepository;
import com.c4ccup.laugh.repository.ComedyStyleRepository;
import com.c4ccup.laugh.repository.ComposerRepository;
import com.c4ccup.laugh.repository.OwnComedyStyleRepository;
import com.c4ccup.laugh.repository.OwnSpecialSkillRepository;
import com.c4ccup.laugh.repository.UserRepository;


/**
 * CRUDを操作するTopクラス
 *
 */
@RequestMapping(value = "top")
@RestController
public class TopController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComedianRepository comedianRepository;
    @Autowired
    private ComposerRepository composerRepository;
    @Autowired
    private ComedyStyleRepository comedyStyleRepository;
    @Autowired
    private OwnSpecialSkillRepository ownSpecialSkillRepository;
    @Autowired
    private OwnComedyStyleRepository ownComedyStyleRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public TopBean init(UserBean userBean) {
        
        TopBean topBean = new TopBean();
        userBean.setUserType(1);
        List<User> userList = new ArrayList<>();
        List<OwnSpecialSkill> ownSpecialSkillList = new ArrayList<>();
        List<UserBean> chgUserList = new ArrayList<>();
        List<OwnComedyStyle> ownComedyStyleList = new ArrayList<>();
        List<String> belongList = new ArrayList<>();
        
        //芸風・得意分野のリストを取得
        ownComedyStyleList = ownComedyStyleRepository.getOwnComedyStyleList();
        //作家の情報を取得
        if (userBean.getUserType() == UserTypeEnum.COMPOSER.getUserType()) {
            //作家リストを取得
            userList = userRepository.getComposerList(userBean);
            //特殊スキルリストを取得
            ownSpecialSkillList = ownSpecialSkillRepository.getOwnSpecialSkillList();
            //取得した値を表示用にセット
            for (int i=0; i<userList.size(); i++) {
                UserBean user = new UserBean();
                //芸人・作家共通処理
                user = this.setUserInfo(user, userList, i);
                Map<Integer, String> ownComedyStyleMap = new HashMap<>();
                for (int j=0; j<ownComedyStyleList.size(); j++) {
                    OwnComedyStyle ownComedyStyle = ownComedyStyleList.get(j);
                    if (user.getId() == ownComedyStyle.getUserId()) {
                        ownComedyStyleMap.put(ownComedyStyle.getComedyStyleId().getId(), ownComedyStyle.getComedyStyleId().getStyleName());
                    }
                }
                user.setComedyStyle(ownComedyStyleMap);
                
                //作家用処理
                Composer composer = userList.get(i).getComposerProfile();
                user.setFeeType(composer.getFeeType());
                user.setFee(composer.getFee());
                //特殊スキルセット処理
                Map<Integer, String> ownSpecialSkillMap = new HashMap<>();
                for (int j=0; j<ownSpecialSkillList.size(); j++) {
                    OwnSpecialSkill ownSpecialSkill = ownSpecialSkillList.get(j);
                    if (user.getId() == ownSpecialSkill.getUserId()) {
                        if (ownSpecialSkill.getAnotherSkillName() == null) {
                            ownSpecialSkillMap.put(ownSpecialSkill.getSpecialSkillId().getId(), ownSpecialSkill.getSpecialSkillId().getSpecialSkillName());
                        } else {
                            ownSpecialSkillMap.put(ownSpecialSkill.getSpecialSkillId().getId(), ownSpecialSkill.getAnotherSkillName());
                        }
                    }
                }
                user.setSkill(ownSpecialSkillMap);
                chgUserList.add(user);
            }
//            belongList = composerRepository.getBelongList();
        } else {
            //芸人の情報を取得
            userList = userRepository.getComedianList(userBean);
            for (int i=0; i<userList.size(); i++) {
                UserBean user = new UserBean();
                //芸人・作家共通処理
                user = this.setUserInfo(user, userList, i);
                //芸人用処理
                Comedian comedian = userList.get(i).getComedianProfile();
                user.setMemberNum(comedian.getMemberNum());
                chgUserList.add(user);
            }
//            belongList = comedianRepository.getBelongList();
        }
        
        List<ComedyStyle> comedyStyleList = new ArrayList<>();
        comedyStyleList = comedyStyleRepository.getComedyStyleList();
//        List<Integer> feeList = new ArrayList<>();
//        feeList = composerRepository.getFeeList();
//        
//        List<String> skillList = new ArrayList<>();
//        skillList = composerRepository.getSkillList();
        
        topBean.setUserList(chgUserList);
//        topBean.setBelongList(belongList);
        topBean.setComedyStyleList(comedyStyleList);
//        topBean.setOwnComedyStyleList(comedyStyleList);
//        topBean.setFeeList(feeList);
//        topBean.setSkillList(skillList);
        
        return topBean;
    }
    
    public UserBean setUserInfo(UserBean user, List<User> userList, int i) {
        user.setId(userList.get(i).getId());
        user.setUserName(userList.get(i).getUserName());
        user.setUserNameKana(userList.get(i).getUserNameKana());
        user.setUserType(userList.get(i).getUserType());
        user.setDebutDt(userList.get(i).getDebutDt());
        user.setGender(userList.get(i).getGender());
        Office office = userList.get(i).getOfficeId();
        user.setOfficeId(office.getId());
        user.setOfficeName(office.getOfficeName());
        Area area = userList.get(i).getAreaId();
        user.setAreaId(area.getId());
        user.setAreaName(area.getAreaName());
        user.setSelfIntroduction(userList.get(i).getSelfIntroduction());
        user.setProfileImg(userList.get(i).getProfileImg());
        user.setLoginAt(userList.get(i).getLoginAt());
        user.setUpdateAt(userList.get(i).getUpdateAt());
        return user;
    }
}

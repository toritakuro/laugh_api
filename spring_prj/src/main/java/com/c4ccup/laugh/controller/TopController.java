package com.c4ccup.laugh.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.domain.User;
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

    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> init(@RequestParam int userType) {
//    public ResponseEntity<List<UserBean>> init() {
        
//        int userType = UserTypeEnum.COMEDIAN.getUserType();
//        int userType = UserTypeEnum.COMPOSER.getUserType();
        
        List<UserBean> topUserList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        
        // ユーザーの一覧を取得
        if (userType == UserTypeEnum.COMEDIAN.getUserType()) {
            // 作家一覧を取得
            userList = userRepository.getComposerList2(UserTypeEnum.COMPOSER.getUserType());
        } else {
         // 芸人一覧を取得
            userList = userRepository.getComedianList2(UserTypeEnum.COMEDIAN.getUserType());
        }
        // 取得した値を表示用にセット
        for (User user : userList) {
            // 作家・芸人共通処理
            UserBean users = new UserBean(user);
            this.setActivityNum(users);
            List<Integer> comedyIdList = new ArrayList<>();
            comedyIdList = this.strToIntegerList(user.getComedyStyleIds());
            users.setComedyStyleId(comedyIdList);
            // 作家用
            if (users.getUserType() == UserTypeEnum.COMPOSER.getUserType()) {
                List<Integer> specialSkillIdList = new ArrayList<>();
                specialSkillIdList = this.strToIntegerList(user.getSpecialSkillIds());
                users.setSkillId(specialSkillIdList);
            } else {
                // 芸人用
                this.setActivityNum(users);
            }
            topUserList.add(users);
        }
        return ResponseEntity.ok(topUserList);
    }

    /**
     * idをString型からInteger型のリストに変換する
     * @param ids
     * @return idList
     */
    private List<Integer> strToIntegerList(String ids) {
        String[] strIds = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String str : strIds) {
            idList.add(Integer.parseInt(str));
        }
        return idList;
    }

    /**
     * 活動年月のセット処理  作家・芸人共通
     * @param users
     * @param ownComedyStyleList
     */
    private void setActivityNum(UserBean users) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.minusYears(users.getDebutDt().getYear());
        LocalDate date2 = date1.minusMonths(users.getDebutDt().getMonthValue());
        String activityYear = Integer.valueOf(date2.getYear()).toString();
        String activityMonth = Integer.valueOf(date2.getMonthValue()).toString();
        String activityDate;
        int activityNum = date2.getYear();
        if (0 < date2.getYear()) {
            activityDate = activityYear + " 年 " + activityMonth + " ヶ月 " ;
        } else {
            activityDate = activityMonth + " ヶ月 " ;
        }
        users.setActivityDt(activityDate);
        users.setActivityNum(activityNum);
    }
}

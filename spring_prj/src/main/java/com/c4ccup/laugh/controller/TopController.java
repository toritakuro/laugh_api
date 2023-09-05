package com.c4ccup.laugh.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.TopBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.TopResource;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.Util;


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
    public ResponseEntity<ApiResource<List<TopResource>>> init(TopBean bean) {

        List<TopResource> topUserList = new ArrayList<>();
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
        // 取得した値を表示用にセット
        for (User user : userList) {
            // 作家・芸人共通処理
            TopResource users = new TopResource(user);
            this.setActivityNum(users);
            // 文字列を分割し配列に格納
            String[] comedyIdStrList = user.getComedyStyleIds().split(",");
            // int型に変換
            List<Integer> comedyIdList = Util.chgToInt(comedyIdStrList);
            users.setComedyStyleIdList(comedyIdList);

            // 作家用
            if (users.getUserType() == UserEnum.COMPOSER.getId()) {
                // 文字列を分割し配列に格納
                String[] specialSkillIdStrList = user.getSpecialSkillIds().split(",");
                // int型に変換
                List<Integer> specialSkillIdList = Util.chgToInt(specialSkillIdStrList);
                users.setSpecialSkillIdList(specialSkillIdList);
            } else {
                // 芸人用
                this.setActivityNum(users);
            }
            topUserList.add(users);
        }
        return ResponseEntity.ok(new ApiResource<>(topUserList));
    }

    /**
     * 活動年月のセット処理  作家・芸人共通
     * @param users
     */
    private void setActivityNum(TopResource users) {
        // 現在日付を取得
        LocalDate date = LocalDate.now();
        // 現在日付と活動開始年月の差分を取得
        LocalDate differenceYear = date.minusYears(users.getDebutDt().getYear());
        LocalDate differenceDate = differenceYear.minusMonths(users.getDebutDt().getMonthValue());
        // String型に変換
        String activityYear = Integer.valueOf(differenceDate.getYear()).toString();
        String activityMonth = Integer.valueOf(differenceDate.getMonthValue()).toString();
        String activityDate;
        // 活動年数
        int activityNum = differenceDate.getYear();
        // 画面表示用にセット
        if (0 < differenceDate.getYear()) {
            activityDate = activityYear + " 年 " + activityMonth + " ヶ月 " ;
        } else {
            activityDate = activityMonth + " ヶ月 " ;
        }
        users.setActivityDt(activityDate);
        users.setActivityNum(activityNum);
    }
}

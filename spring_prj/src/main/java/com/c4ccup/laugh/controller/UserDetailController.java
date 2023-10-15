package com.c4ccup.laugh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.controller.bean.req.UserDetailBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.OogiriAnswerResources;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.Oogiri;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.MatchStatusRepository;
import com.c4ccup.laugh.repository.OogiriRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.EnumConst.MatchStatus;

/**
 * ユーザー詳細 Controllerクラス
 */
@RequestMapping(value = "userDetail")
@RestController
public class UserDetailController extends _CmnController{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OogiriRepository oogiriRepository;
    @Autowired
    private MatchStatusRepository matchStatusRepository;

    /**
     * ユーザー情報を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<UserResource>> init(MyPageBean bean) {
        int userType = bean.getUserType();
        User user = new User();
        if (userType == UserEnum.COMEDIAN.getId()) {
            user = userRepository.getComedian(bean.getUserId());
        } else {
            user = userRepository.getComposer(bean.getUserId());
        }
        
        return ResponseEntity.ok(new ApiResource<>(new UserResource(user)));
    }

    /**
     * ユーザーの大喜利回答一覧を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(path = "/oogiriAnswer", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<OogiriAnswerResources>> oogiriAnswer(MyPageBean bean) {
        List<Oogiri> oogiriList  = oogiriRepository.getAnswerByUserId(bean);
        OogiriAnswerResources res = new OogiriAnswerResources();
        res.setAnswerList(oogiriList);
        return ResponseEntity.ok(new ApiResource<>(res));
    }

    /**
     * マッチステータス登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/regMatch", method = RequestMethod.POST)
    public void regMatch(@RequestBody UserDetailBean bean) {
        int matchStatus = bean.getMatchStatus();

        if (matchStatus == MatchStatus.PRE_MATCH.getStatus()) {
            matchStatusRepository.regMatchStatus(bean);
        } else if (matchStatus == MatchStatus.SUPER_LAUGHT.getStatus()) {
            //スーパーラフの処理を記述
        } else if (matchStatus == MatchStatus.CANCEL.getStatus()) {
            //キャンセルの処理を記述
        }
    }
}

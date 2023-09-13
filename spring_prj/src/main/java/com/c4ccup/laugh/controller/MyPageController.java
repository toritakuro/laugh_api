package com.c4ccup.laugh.controller;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.LaughResource;
import com.c4ccup.laugh.domain.Laugh;
import com.c4ccup.laugh.repository.MyPageRepository;
import static com.c4ccup.laugh.util.EnumConst.*;

/**
 * マイページ Controllerクラス
 */
@RequestMapping(value = "mypage")
@RestController
public class MyPageController {

    @Autowired
    MyPageRepository repository;

    /**
     * laughの一覧を取得する。自分が送ったlaughと送られたlaughを取得する
     * @param bean
     * @return
     */
    @RequestMapping(value ="laugh" , method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<LaughResource>>> laughList(MyPageBean bean) {
        List<Laugh> LaughList = repository.selectLaugh(bean.getUserId());
        List<LaughResource> result = new ArrayList<>();

        // Loughの一覧設定
        for (Laugh l : LaughList) {
            LaughResource r = new LaughResource();
            int[] activeTerm = null;

            r.setId(l.getId());
            r.setStatus(l.getStatus());
            r.setStatusStr(MatchStatus.getValByKey(l.getStatus()));

            if (l.getReceiveUserId() == bean.getUserId()) {
                r.setName(l.getUserNameSend());
                r.setTargetUserId(l.getUserIdSend());
                r.setMySendLough(false);
                activeTerm= getActiveTerm(l.getUerDebutAtSend());
            }
            if (l.getSendUserId() == bean.getUserId()) {
                r.setName(l.getUserNameReceive());
                r.setTargetUserId(l.getUserIdReceive());
                r.setMySendLough(true);
                activeTerm = getActiveTerm(l.getUserDebutAtReceive());
            }
            r.setActiveTermYear(activeTerm[0]);
            r.setActiveTermMonth(activeTerm[1]);

            result.add(r);
        }

        return ResponseEntity.ok(new ApiResource<>(result));
    }

    /**
     * 活動歴を取得する
     * @param debutAt
     * @return int[] 0:年、1:月
     */
    private int[] getActiveTerm(LocalDate debutAt) {
        int month = (int) ChronoUnit.MONTHS.between(debutAt.withDayOfMonth(1), LocalDate.now().withDayOfMonth(1)) + 1;
        return new int[]{(month / 12),(month % 12)};
    }
}

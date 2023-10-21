package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.MasterResource;
import com.c4ccup.laugh.domain.Area;
import com.c4ccup.laugh.domain.Office;
import com.c4ccup.laugh.repository.MasterRepository;

/**
 * マスターControllerクラス
 */
@RestController
@RequestMapping(value = "master")
public class MasterController {

    @Autowired
    MasterRepository repository;

    /**
     * 事務所一覧を取得
     * @return
     */
    @RequestMapping(path = "/office",  method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<MasterResource>>> officeList() {
        List<Office> offices = repository.findOfficeList();
        List<MasterResource> list = new ArrayList<>();
        MasterResource m = null;
        for (Office office : offices) {
            m = new MasterResource();
            m.setId(office.getId());
            m.setName(office.getOfficeName());
            list.add(m);
        }
        return ResponseEntity.ok(new ApiResource<>(list));
    }

    /**
     * 活動場所一覧を取得
     * @return
     */
    @RequestMapping(path = "/area",  method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<MasterResource>>> areaList() {
        List<Area> areas = repository.findAreaList();
        List<MasterResource> list = new ArrayList<>();
        MasterResource m = null;
        for (Area a : areas) {
            m = new MasterResource();
            m.setId(a.getId());
            m.setName(a.getAreaName());
            list.add(m);
        }
        return ResponseEntity.ok(new ApiResource<>(list));
    }
}

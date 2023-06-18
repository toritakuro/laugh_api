package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.DemoBean;
import com.c4ccup.laugh.domain.Demo;
import com.c4ccup.laugh.repository.DemoRepository;

/**
 * CRUDを操作するDemoクラス
 *
 */
@RequestMapping(value = "demo")
@RestController
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    /**
     * IDで取得
     * @param id
     * @return
     */
    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public Demo init(@RequestParam int id) {
        Demo demo = demoRepository.findById(id);
        return demo;
    }

    /**
     * Listで取得
     * @return
     */
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Demo> initList() {
        List<Demo> demoList = new ArrayList<>();
        demoList = demoRepository.findAll();
        return demoList;
    }

    /**
     * 新規登録するデモメソッド
     * @param id
     * @return
     */
    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody DemoBean demoBean) {
        demoRepository.insert(demoBean);
    }

    /**
     * 更新するデモメソッド
     * @param id
     * @return
     */
    @RequestMapping(path = "/update", method = RequestMethod.GET)
    public void update(@RequestBody DemoBean demoBean) {
        demoRepository.update(demoBean);
    }



    @RequestMapping(path = "/initWork", method = RequestMethod.GET)
    public Demo initWork(DemoBean demoBean) {
        demoBean.setId(1);
        Demo demo = demoRepository.findWorkById(demoBean.getId());
        System.out.println(demo);
        return demo;
    }

    @RequestMapping(path = "/initWorkList", method = RequestMethod.GET)
    public List<Demo> initWorkList() {
        List<Demo> demoList = new ArrayList<>();
        demoList = demoRepository.findAllWork();
        return demoList;
    }

}

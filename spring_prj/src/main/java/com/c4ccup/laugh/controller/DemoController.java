package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.DemoBean;
import com.c4ccup.laugh.domain.Demo;
import com.c4ccup.laugh.repository.DemoRepository;

/**
 * CRUDを操作するDemoクラス
 *
 */
@RequestMapping(value="demo")
@RestController
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @RequestMapping(path = "/init", method = RequestMethod.GET)
    public Demo init(DemoBean demoBean) {
    	demoBean.setId(1);
        Demo demo = demoRepository.findById(demoBean.getId());
        System.out.println(demo);
        return demo;
    }
    
    @RequestMapping(path = "/insert", method = RequestMethod.GET)
    public void insert(DemoBean demoBean) {
    	demoBean.setTitle("abbc");
		demoRepository.insert(demoBean);
	}

    @RequestMapping(path = "/update", method = RequestMethod.GET)
    public void update(DemoBean demoBean) {
    	demoBean.setTitle("sushi");
    	demoBean.setId(1);
		demoRepository.update(demoBean);
	}
    
    @RequestMapping(path = "/initList", method = RequestMethod.GET)
    public List<Demo> initList() {
    	List<Demo> demoList = new ArrayList<>();
    	demoList = demoRepository.findAll();
        System.out.println(demoList);
        return demoList;
    }
}

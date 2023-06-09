package com.c4ccup.laugh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET)
    public String init() {
        Demo demo = demoRepository.findById(1);
        demoRepository.isert();
        System.out.println(demo);
        return demo.getTitle();
    }

}

package com.c4ccup.laugh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.res._Cmn;
import com.c4ccup.laugh.util.AwsSesUtil;
import com.c4ccup.laugh.util.JwtUtil;
import com.c4ccup.laugh.util.PasswordUtil;

@SpringBootApplication
@RestController
public class LaughApplication {

    @Autowired
    private AwsSesUtil awsSesUtil;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordUtil passwordUtil;

    public static void main(String[] args) {
        SpringApplication.run(LaughApplication.class, args);
    }

    @RequestMapping("/")
    public _Cmn home() {
        _Cmn cm = new _Cmn();
        List<String> a =new ArrayList<>();
        //a.add("aaaa");
        cm.setMessages(a);
        return cm;
    }

    @RequestMapping("/demoMail")
    public String mailDemo() {
        awsSesUtil.send("m.masayoshi.0418@gmail.com", "title", "本文、HTMLも可能");
        return "変更しました";
    }

}

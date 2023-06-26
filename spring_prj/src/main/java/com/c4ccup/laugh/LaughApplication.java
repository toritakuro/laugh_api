package com.c4ccup.laugh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.util.AwsSesUtil;
import com.c4ccup.laugh.util.JwtUtil;

@SpringBootApplication
@RestController
public class LaughApplication {

    @Autowired
    private AwsSesUtil awsSesUtil;

	public static void main(String[] args) {
		SpringApplication.run(LaughApplication.class, args);
	}

    @RequestMapping("/")
    public String home() {
        return "変更しました";
    }

    @RequestMapping("/demoMail")
    public String mailDemo() {
        awsSesUtil.send("m.masayoshi.0418@gmail.com", "title", "本文、HTMLも可能");
        return "変更しました";
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}

package com.c4ccup.laugh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LaughApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaughApplication.class, args);
	}

    @RequestMapping("/")
    public String home() {
        return "変更しました";
    }
}

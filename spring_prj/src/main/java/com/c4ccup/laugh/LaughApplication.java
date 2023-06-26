package com.c4ccup.laugh;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.util.JwtUtil;

import io.jsonwebtoken.SignatureAlgorithm;

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
    
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}

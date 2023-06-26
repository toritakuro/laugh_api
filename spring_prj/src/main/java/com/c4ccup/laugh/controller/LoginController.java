package com.c4ccup.laugh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.JwtUtil;

@RestController
public class LoginController {
    
	private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LoginController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }
    
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    	
    	String email = request.getEmail();
        String password = request.getPassword();
        
        // メールアドレスを使用してデータベースからユーザーを取得
        User user = userRepository.findByMail(email);
        
        if (user != null && user.getPassword().equals(password)) {
            // 認証成功
            
            // JWTを発行する処理
        	String jwt = jwtUtil.generateToken(email);
            
        	ResponseEntity<String> test = ResponseEntity.ok(jwt);
            // レスポンスとしてJWTを返す
            return test;
        } else {
            // 認証が失敗した場合は401 Unauthorizedを返す
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
}

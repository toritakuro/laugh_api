package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.JwtUtil;
import com.c4ccup.laugh.util.PasswordUtil;

/**
 * ログインContorollerクラス
 *
 */
@RestController
public class LoginController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LoginController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    /**
     * ログイン認証
     * 
     * @param request ログインリクエストのボディ
     * @return JWTとユーザー情報を含むレスポンスエンティティ
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        String email = request.getEmail();
        String password = request.getPassword();
        LocalDateTime now = LocalDateTime.now();

        // メールアドレスを使用してデータベースからユーザーを取得
        User user = userRepository.findByMail(email);

        // ユーザーが取得できるかつ、パスワードの検証がOK
        if (user != null && PasswordUtil.matches(password, user.getPassword())) {
            // ログイン日時を更新
            updateLoginAt(user, now);
            // JWTを発行する処理
            String jwt = jwtUtil.generateToken(email);
            LoginResponse response = new LoginResponse(jwt, user);
            // レスポンスとしてJWTとユーザー情報を返す
            return ResponseEntity.ok(response);
        } else {
            // 認証が失敗した場合は401 Unauthorizedを返す
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * ログイン日時更新
     * 
     * @param user ユーザーオブジェクト
     * @param now  システム時刻
     */
    public void updateLoginAt(User user, LocalDateTime now) {
        user.setLoginAt(now);
        userRepository.updateLoginAt(user);
    }

}
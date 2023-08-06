package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.JwtUtil;
import com.c4ccup.laugh.util.MessageUtil;
import com.c4ccup.laugh.util.PasswordUtil;

/**
 * ログインControllerクラス
 *
 */
@RestController
public class LoginController extends _CmnController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final MessageUtil messageUtil;

    public LoginController(UserRepository userRepository, JwtUtil jwtUtil, MessageUtil messageUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.messageUtil = messageUtil;
    }

    /**
     * ログイン認証
     * 
     * @param request ログインリクエストのボディ
     * @return JWTとユーザー情報を含むレスポンスエンティティ
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws LoginException {

        String email = request.getEmail();
        String password = request.getPassword();
        LocalDateTime now = LocalDateTime.now();

        // メールアドレスを使用してデータベースからユーザーを取得
        User user = userRepository.findByMail(email);

        // ユーザーが取得できない場合エラーを返す
        if (user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        // パスワードチェック
        PasswordUtil.matches(password, user.getPassword(), messageUtil);

        // ログイン日時を更新
        user.setLoginAt(now);
        userRepository.updateLoginAt(user);
        // JWTを発行する処理
        String jwt = jwtUtil.generateToken(email);
        LoginResponse response = new LoginResponse(jwt, user);
        // レスポンスとしてJWTとユーザー情報を返す
        return ResponseEntity.ok(response);
    }

}
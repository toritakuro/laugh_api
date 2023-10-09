package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.JwtUtil;
import com.c4ccup.laugh.util.PasswordUtil;

/**
 * ログインControllerクラス
 *
 */
@RestController
public class LoginController extends _CmnController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordUtil pwdUtil;

    public LoginController(UserRepository userRepository, JwtUtil jwtUtil, PasswordUtil pwdUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.pwdUtil = pwdUtil;
    }

    /**
     * ログイン認証
     * 
     * @param request ログインリクエストのボディ
     * @return JWTとユーザー情報を含むレスポンスエンティティ
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<UserResource>> login(@RequestBody LoginRequest request) throws LoginException {

        String email = request.getEmail();
        String password = request.getPassword();
        LocalDateTime now = LocalDateTime.now();

        // メールアドレスを使用してデータベースからユーザーを取得
        User user = userRepository.findByMail(email);

        // ユーザーが取得できない場合エラーを返す
        if (user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        // パスワードチェック
        pwdUtil.matches(password, user.getPassword());

        // ログイン日時を更新
        user.setLoginAt(now);
        userRepository.updateLoginAt(user);
        // トークンを発行する処理
        String idToken = jwtUtil.generateToken(email);
        String refreshToken = jwtUtil.generateRefreshToken(email);
        UserResource response = new UserResource();
        // レスポンスとしてJWTとユーザーID,タイプを返す
        response.setIdToken(idToken);
        response.setRefreshToken(refreshToken);
        response.setId(user.getId());
        response.setUserType(user.getUserType());
        ApiResource<UserResource> res = new ApiResource<>(response);
        return ResponseEntity.ok(res);
    }

}
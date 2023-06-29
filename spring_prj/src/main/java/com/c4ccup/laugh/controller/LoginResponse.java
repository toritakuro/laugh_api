package com.c4ccup.laugh.controller;

import com.c4ccup.laugh.domain.User;

/**
 * ログイン レスポンスクラス
 *
 */

public class LoginResponse {
    private String jwt;
    private User user;

    public LoginResponse(String jwt, User user) {
        this.jwt = jwt;
        this.user = user;
    }

    /**
     * JWTを取得
     *
     * @return JWTの文字列
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * ログインユーザーの情報を取得
     *
     * @return ログインユーザーのUserオブジェクト
     */
    public User getUser() {
        return user;
    }
}

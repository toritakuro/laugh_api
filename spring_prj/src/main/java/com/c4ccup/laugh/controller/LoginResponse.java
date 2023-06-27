package com.c4ccup.laugh.controller;

import com.c4ccup.laugh.domain.User;

public class LoginResponse {
	private String jwt;
    private User user;

    public LoginResponse(String jwt, User user) {
        this.jwt = jwt;
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public User getUser() {
        return user;
    }
}

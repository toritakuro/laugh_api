package com.c4ccup.laugh.controller.bean.req;

/**
 * ログインBean
 *
 */
public class LoginBean {

    private String email;
    private String password;

    /**
     * メールアドレスを取得
     * 
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを設定
     * 
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * パスワードを取得
     * 
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定
     * 
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

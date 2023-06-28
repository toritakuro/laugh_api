package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

/**
 * Userテーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 */
public class User {

    /** id */
    private int id;
    /** ユーザアドレス */
    private String userAddress;
    /** ユーザ名 */
    private String userName;
    /** ユーザ名(かな) */
    private String userNameKana;
    /** 活動種別 */
    private int userType;
    /** パスワード */
    private String password;
    /** 退会フラグ */
    private int deleteFlg;
    /** ログイン日時 */
    private LocalDateTime loginAt;
    /** 作成日時 */
    private LocalDateTime createAt;
    /** 更新日時 */
    private LocalDateTime updateAt;

    /**
     * idを取得
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id セットする id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * userAddressを取得
     * 
     * @return userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * @param userAddress セットする userAddress
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * userNameを取得
     * 
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName セットする userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * userNameKanaを取得
     * 
     * @return userNameKana
     */
    public String getUserNameKana() {
        return userNameKana;
    }

    /**
     * @param userNameKana セットする userNameKana
     */
    public void setUserNameKana(String userNameKana) {
        this.userNameKana = userNameKana;
    }

    /**
     * userTypeを取得
     * 
     * @return userType
     */
    public int getUserType() {
        return userType;
    }

    /**
     * @param userType セットする userType
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * passwordを取得
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * deleteFlgを取得
     * 
     * @return deleteFlg
     */
    public int getDeleteFlg() {
        return deleteFlg;
    }

    /**
     * @param deleteFlg セットする deleteFlg
     */
    public void setDeleteFlg(int deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * loginAtを取得
     * 
     * @return loginAt
     */
    public LocalDateTime getLoginAt() {
        return loginAt;
    }

    /**
     * @param loginAt セットする loginAt
     */
    public void setLoginAt(LocalDateTime loginAt) {
        this.loginAt = loginAt;
    }

    /**
     * createAtを取得
     * 
     * @return createAt
     */
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt セットする createAt
     */
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    /**
     * updateAtを取得
     * 
     * @return updateAt
     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt セットする updateAt
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}

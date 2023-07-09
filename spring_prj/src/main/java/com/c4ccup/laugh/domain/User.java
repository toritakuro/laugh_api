package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;
import java.util.Date;

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
    /** 活動開始年月 */
    private Date debutDt;
    /** 性別 */
    private int gender;
    /** 事務所ID */
    private int officeId;
    /** 活動場所ID */
    private int areaId;
    /** 自己紹介文 */
    private String selfIntroduction;
    /** プロフィール画像 */
    private String profileImgPath;
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
     * debutDtを取得
     *
     * @return debutDt
     */
    public Date getDebutDt() {
        return debutDt;
    }

    /**
     * @param debutDt セットする debutDt
     */
    public void setDebutDt(Date debutDt) {
        this.debutDt = debutDt;
    }

    /**
     * genderを取得
     *
     * @return gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * @param gender セットする gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * officeIdを取得
     *
     * @return officeId
     */
    public int getOfficeId() {
        return officeId;
    }

    /**
     * @param officeId セットする officeId
     */
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    /**
     * areaIdを取得
     *
     * @return areaId
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * @param areaId セットする areaId
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    /**
     * selfIntroductionを取得
     *
     * @return selfIntroduction
     */
    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    /**
     * @param selfIntroduction セットする selfIntroduction
     */
    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    /**
     * profileImgPathを取得
     *
     * @return profileImgPath
     */
    public String getProfileImgPath() {
        return profileImgPath;
    }

    /**
     * @param profileImgPath セットする profileImgPath
     */
    public void setProfileImgPath(String profileImgPath) {
        this.profileImgPath = profileImgPath;
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

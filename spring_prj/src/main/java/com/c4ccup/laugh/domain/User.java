package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

/**
 * Userテーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 */
public class User {

    /** id */
    private int id;
    /** ユーザアドレス */
    private String mail;
    /** ユーザ名 */
    private String userName;
    /** ユーザ名(かな) */
    private String userNameKana;
    /** 活動種別 */
    private int userType;
    /** パスワード */
    private String password;
    /** 活動開始年月 */
    private LocalDateTime debutDt;
    /** 性別 */
    private int gender;
    /** 事務所 */
    private Office officeId;
    /** 活動場所 */
    private Area areaId;
    /** 自己紹介文 */
    private String selfIntroduction;
    /** プロフィール画像 */
    private String profileImg;
    /** 退会フラグ */
    private int deleteFlg;
    /** ログイン日時 */
    private LocalDateTime loginAt;
    /** 作成日時 */
    private LocalDateTime createAt;
    /** 更新日時 */
    private LocalDateTime updateAt;
    /** 作家詳細 */
    private Composer composerProfile;
    /** 芸人詳細 */
    private Comedian comedianProfile;
//    /** 特殊スキルリスト */
//    private  List<OwnSpecialSkill> ownSpecialSkillList;

    /**
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
     * @return mail
     */
    public String getMail() {
        return mail;
    }
    /**
     * @param mail セットする mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    /**
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
     * @return debutDt
     */
    public LocalDateTime getDebutDt() {
        return debutDt;
    }
    /**
     * @param debutDt セットする debutDt
     */
    public void setDebutDt(LocalDateTime debutDt) {
        this.debutDt = debutDt;
    }
    /**
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
     * @return officeId
     */
    public Office getOfficeId() {
        return officeId;
    }
    /**
     * @param officeId セットする officeId
     */
    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }
    /**
     * @return areaId
     */
    public Area getAreaId() {
        return areaId;
    }
    /**
     * @param areaId セットする areaId
     */
    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }
    /**
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
     * @return profileImg
     */
    public String getProfileImg() {
        return profileImg;
    }
    /**
     * @param profileImg セットする profileImg
     */
    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
    /**
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
    /**
     * @return composerProfile
     */
    public Composer getComposerProfile() {
        return composerProfile;
    }
    /**
     * @param composerList セットする composerList
     */
    public void setComposerProfile(Composer composerProfile) {
        this.composerProfile = composerProfile;
    }
    /**
     * @return comedianList
     */
    public Comedian getComedianProfile() {
        return comedianProfile;
    }
    /**
     * @param comedianList セットする comedianList
     */
    public void setComedianProfile(Comedian comedianProfile) {
        this.comedianProfile = comedianProfile;
    }
//    /**
//     * @return ownSpecialSkillList
//     */
//    public List<OwnSpecialSkill> getOwnSpecialSkillList() {
//        return ownSpecialSkillList;
//    }
//    /**
//     * @param ownSpecialSkillList セットする ownSpecialSkillList
//     */
//    public void setOwnSpecialSkillList(List<OwnSpecialSkill> ownSpecialSkillList) {
//        this.ownSpecialSkillList = ownSpecialSkillList;
//    }
}

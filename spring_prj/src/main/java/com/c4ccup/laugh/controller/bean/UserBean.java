package com.c4ccup.laugh.controller.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.c4ccup.laugh.domain.User;

public class UserBean {

    /** id */
    private int id;
    /** ユーザー名 */
    private String userName;
    /** ユーザー名(カナ) */
    private String userNameKana;
    /** ユーザータイプ */
    private int userType;
    /** 活動開始年月 */
    private LocalDate debutDt;
    /** 性別 */
    private int gender;
    /** コメディスタイルid */
    private List<Integer> comedyStyleId;
    /** コメディスタイル名 */
    private List<String> comedyStyleName;
    /** オフィスid */
    private int officeId;
    /** オフィス名 */
    private String officeName;
    /** エリアid */
    private int areaId;
    /** エリア名 */
    private String areaName;
    /** 自己紹介 */
    private String selfIntroduction;
    /** プロフィール画像 */
    private String profileImg;
    /** ログイン日付 */
    private LocalDateTime loginAt;
    /** アップデート日付 */
    private LocalDateTime updateAt;
    /** 料金タイプ */
    private int feeType;
    /** 料金 */
    private int fee;
    /** スキルid */
    private List<Integer> skillId;
    /** スキル名 */
    private List<String> skillName;
    /** 活動人数 */
    private int memberNum;


    public UserBean() {
        
    }
    
    public UserBean(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userNameKana = user.getUserNameKana();
        this.userType = user.getUserType();
        this.debutDt = user.getDebutDt();
        this.gender = user.getGender();
        this.officeId = user.getOfficeId().getId();
        this.officeName = user.getOfficeId().getOfficeName();
        this.areaId = user.getAreaId().getId();
        this.areaName = user.getAreaId().getAreaName();
        this.selfIntroduction = user.getSelfIntroduction();
        this.profileImg = user.getProfileImg();
        this.loginAt = user.getLoginAt();
        this.updateAt = user.getUpdateAt();
    }
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
     * @return debutDt
     */
    public LocalDate getDebutDt() {
        return debutDt;
    }
    /**
     * @param debutDt セットする debutDt
     */
    public void setDebutDt(LocalDate debutDt) {
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
     * @return comedyStyleId
     */
    public List<Integer> getComedyStyleId() {
        return comedyStyleId;
    }

    /**
     * @param comedyStyleId セットする comedyStyleId
     */
    public void setComedyStyleId(List<Integer> comedyStyleId) {
        this.comedyStyleId = comedyStyleId;
    }

    /**
     * @return comedyStyleName
     */
    public List<String> getComedyStyleName() {
        return comedyStyleName;
    }
    /**
     * @param comedyStyleName セットする comedyStyleName
     */
    public void setComedyStyleName(List<String> comedyStyleName) {
        this.comedyStyleName = comedyStyleName;
    }
    /**
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
     * @return officeName
     */
    public String getOfficeName() {
        return officeName;
    }
    /**
     * @param officeName セットする officeName
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
    /**
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
     * @return areaName
     */
    public String getAreaName() {
        return areaName;
    }
    /**
     * @param areaName セットする areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
     * @return feeType
     */
    public int getFeeType() {
        return feeType;
    }
    /**
     * @param feeType セットする feeType
     */
    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }
    /**
     * @return fee
     */
    public int getFee() {
        return fee;
    }
    /**
     * @param fee セットする fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }
    /**
     * @return skillId
     */
    public List<Integer> getSkillId() {
        return skillId;
    }

    /**
     * @param skillId セットする skillId
     */
    public void setSkillId(List<Integer> skillId) {
        this.skillId = skillId;
    }

    /**
     * @return skillName
     */
    public List<String> getSkillName() {
        return skillName;
    }

    /**
     * @param skillName セットする skillName
     */
    public void setSkillName(List<String> skillName) {
        this.skillName = skillName;
    }
    /**
     * @return memberNum
     */
    public int getMemberNum() {
        return memberNum;
    }
    /**
     * @param memberNum セットする memberNum
     */
    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }
}
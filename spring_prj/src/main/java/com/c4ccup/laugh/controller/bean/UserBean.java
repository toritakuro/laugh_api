package com.c4ccup.laugh.controller.bean;

import java.time.LocalDateTime;
import java.util.Map;

public class UserBean {
    private int id;
    private String userName;
    private String userNameKana;
    private int userType;
    private LocalDateTime debutDt;
    private int gender;
    private int officeId;
    private String officeName;
    private int areaId;
    private String areaName;
    private String selfIntroduction;
    private String profileImg;
    private LocalDateTime loginAt;
    private LocalDateTime updateAt;
    private int feeType;
    private int fee;
    private Map<Integer, String> skill;
    private int memberNum;

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
     * @return skill
     */
    public Map<Integer, String> getSkill() {
        return skill;
    }
    /**
     * @param skill セットする skill
     */
    public void setSkill(Map<Integer, String> skill) {
        this.skill = skill;
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
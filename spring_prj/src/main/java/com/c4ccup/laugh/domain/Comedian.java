package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Comedian {

    private int id;
    private int userId;
    private Date debutDt;
    private int memberNum;
    private int gender;
    private String belong;
    private int activePlace;
    private String selfIntroduction;
    private String profileImg;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
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
     * @return userId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
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
     * @return belong
     */
    public String getBelong() {
        return belong;
    }
    /**
     * @param belong セットする belong
     */
    public void setBelong(String belong) {
        this.belong = belong;
    }
    /**
     * @return activePlace
     */
    public int getActivePlace() {
        return activePlace;
    }
    /**
     * @param activePlace セットする activePlace
     */
    public void setActivePlace(int activePlace) {
        this.activePlace = activePlace;
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
    
    
}

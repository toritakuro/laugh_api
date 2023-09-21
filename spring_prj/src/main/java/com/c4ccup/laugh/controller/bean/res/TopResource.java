package com.c4ccup.laugh.controller.bean.res;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.util.Util;


/**
 * TopResourceクラス
 */
public class TopResource {

    /** ID */
    private int id;
    /** ユーザ名 */
    private String userName;
    /** ユーザ名(かな) */
    private String userNameKana;
    /** 検索用ユーザ名 */
    private String searchUserName;
    /** 活動種別 */
    private int userType;
    /** 活動開始年月 */
    private LocalDate debutDt;
    /** 活動年月 */
    private String activityDt;
    /** 活動年数 */
    private int activityNum;
    /** 性別 */
    private int gender;
    /** 事務所ID */
    private int officeId;
    /** オフィス名 */
    private String officeName;
    /** 活動場所ID */
    private int areaId;
    /** 活動地域名 */
    private String areaName;
    /** 自己紹介文 */
    private String selfIntroduction;
    /** プロフィール画像 */
    private byte[] profileImg;
    /** ログイン日時 */
    private LocalDateTime loginAt;
    /** ログイン日時 並び替え用 */
    private Integer loginAtInt;
    /** 更新日時 */
    private LocalDateTime updateAt;
    /** 更新日時 並び替え用 */
    private Integer updateAtInt;
    /** 活動人数 */
    private int memberNum;
    /** 料金体系 */
    private int feeType;
    /** 料金 */
    private int fee;
    /** 得意分野一覧 */
    private List<Integer> comedyStyleIdList;
    /** コメディスタイル名 */
    private String comedyStyleName;
    /** 特殊スキル一覧 */
    private List<Integer> specialSkillIdList;
    /** 特殊スキル名 */
    private String specialSkillName;

    
    public TopResource() {
        
    }

    public TopResource(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userNameKana = user.getUserNameKana();
        this.searchUserName = user.getUserName().replaceAll("　| ","");
        this.userType = user.getUserType();
        this.debutDt = user.getDebutDt();
        this.gender = user.getGender();
        this.comedyStyleName = user.getComedyStyleNames();
        this.officeId = user.getOfficeId().getId();
        this.officeName = user.getOfficeId().getOfficeName();
        this.areaId = user.getAreaId().getId();
        this.areaName = user.getAreaId().getAreaName();
        this.selfIntroduction = user.getSelfIntroduction();
        this.profileImg = user.getProfileImgPath();
        this.loginAt = user.getLoginAt();
        this.loginAtInt = Util.getFormatLocalDateTimeToInt(loginAt);
        this.updateAt = user.getUpdateAt();
        this.updateAtInt = Util.getFormatLocalDateTimeToInt(updateAt);
        if (user.getAnotherSkillNames() != null) {
            this.specialSkillName = (user.getSpecialSkillNames() + user.getAnotherSkillNames());
        } else {
            this.specialSkillName = (user.getSpecialSkillNames());
        }
        this.feeType = user.getComposerProfile().getFeeType();
        this.fee = user.getComposerProfile().getFee();
        this.memberNum = user.getComedianProfile().getMemberNum();
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
     * @return searchUserName
     */
    public String getSearchUserName() {
        return searchUserName;
    }

    /**
     * @param searchUserName セットする searchUserName
     */
    public void setSearchUserName(String searchUserName) {
        this.searchUserName = searchUserName;
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
     * @return activityDt
     */
    public String getActivityDt() {
        return activityDt;
    }

    /**
     * @param activityDt セットする activityDt
     */
    public void setActivityDt(String activityDt) {
        this.activityDt = activityDt;
    }

    /**
     * @return activityNum
     */
    public int getActivityNum() {
        return activityNum;
    }

    /**
     * @param activityNum セットする activityNum
     */
    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
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
    public byte[] getProfileImg() {
        return profileImg;
    }

    /**
     * @param profileImg セットする profileImg
     */
    public void setProfileImg(byte[] profileImg) {
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
     * @return loginAtInt
     */
    public Integer getLoginAtInt() {
        return loginAtInt;
    }

    /**
     * @param loginAtInt セットする loginAtInt
     */
    public void setLoginAtInt(Integer loginAtInt) {
        this.loginAtInt = loginAtInt;
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
     * @return updateAtInt
     */
    public Integer getUpdateAtInt() {
        return updateAtInt;
    }

    /**
     * @param updateAtInt セットする updateAtInt
     */
    public void setUpdateAtInt(Integer updateAtInt) {
        this.updateAtInt = updateAtInt;
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
     * @return comedyStyleIdList
     */
    public List<Integer> getComedyStyleIdList() {
        return comedyStyleIdList;
    }

    /**
     * @param comedyStyleIdList セットする comedyStyleIdList
     */
    public void setComedyStyleIdList(List<Integer> comedyStyleIdList) {
        this.comedyStyleIdList = comedyStyleIdList;
    }

    /**
     * @return comedyStyleName
     */
    public String getComedyStyleName() {
        return comedyStyleName;
    }

    /**
     * @param comedyStyleName セットする comedyStyleName
     */
    public void setComedyStyleName(String comedyStyleName) {
        this.comedyStyleName = comedyStyleName;
    }

    /**
     * @return specialSkillIdList
     */
    public List<Integer> getSpecialSkillIdList() {
        return specialSkillIdList;
    }

    /**
     * @param specialSkillIdList セットする specialSkillIdList
     */
    public void setSpecialSkillIdList(List<Integer> specialSkillIdList) {
        this.specialSkillIdList = specialSkillIdList;
    }

    /**
     * @return specialSkillName
     */
    public String getSpecialSkillName() {
        return specialSkillName;
    }

    /**
     * @param specialSkillName セットする specialSkillName
     */
    public void setSpecialSkillName(String specialSkillName) {
        this.specialSkillName = specialSkillName;
    }
}
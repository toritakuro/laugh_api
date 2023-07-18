package com.c4ccup.laugh.controller.bean;

import java.util.List;

import com.c4ccup.laugh.domain.Area;
import com.c4ccup.laugh.domain.ComedyStyle;
import com.c4ccup.laugh.domain.Office;
import com.c4ccup.laugh.domain.SpecialSkill;

/**
 * TOP画面から取得した値をJavaオブジェクトで扱うためのクラス
 */
public class TopBean {

    /** ユーザーリスト */
    private List<UserBean> userList;
    /** ユーザー名 */
    private String userName;
    /** 性別 */
    private int gender;
    /** 活動歴 何年以上 */
    private int activityNum1;
    /** 活動歴 何年未満 */
    private int activityNum2;
    /** 事務所リスト */
    private List<Office> officeList;
    /** 芸風リスト */
    private List<ComedyStyle> comedyStyleList;
    /** 得意分野リスト */
    private List<ComedyStyle> ownComedyStyleList;
    /** 料金体系リスト */
    private List<String> feeTypeList;
    /** 金額リスト */
    private List<Integer> feeList;
    /** 特殊スキルリスト */
    private List<SpecialSkill> skillList;
    /** 活動場所リスト */
    private List<Area> areaList;

    /**
     * @return userList
     */
    public List<UserBean> getUserList() {
        return userList;
    }
    /**
     * @param userList セットする userList
     */
    public void setUserList(List<UserBean> userList) {
        this.userList = userList;
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
     * @return activityNum1
     */
    public int getActivityNum1() {
        return activityNum1;
    }
    /**
     * @param activityNum1 セットする activityNum1
     */
    public void setActivityNum1(int activityNum1) {
        this.activityNum1 = activityNum1;
    }
    /**
     * @return activityNum2
     */
    public int getActivityNum2() {
        return activityNum2;
    }
    /**
     * @param activityNum2 セットする activityNum2
     */
    public void setActivityNum2(int activityNum2) {
        this.activityNum2 = activityNum2;
    }
    /**
     * @return officeList
     */
    public List<Office> getOfficeList() {
        return officeList;
    }
    /**
     * @param officeList セットする officeList
     */
    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
    }
    /**
     * @return comedyStyleList
     */
    public List<ComedyStyle> getComedyStyleList() {
        return comedyStyleList;
    }
    /**
     * @param comedyStyleList セットする comedyStyleList
     */
    public void setComedyStyleList(List<ComedyStyle> comedyStyleList) {
        this.comedyStyleList = comedyStyleList;
    }
    /**
     * @return ownComedyStyleList
     */
    public List<ComedyStyle> getOwnComedyStyleList() {
        return ownComedyStyleList;
    }
    /**
     * @param ownComedyStyleList セットする ownComedyStyleList
     */
    public void setOwnComedyStyleList(List<ComedyStyle> ownComedyStyleList) {
        this.ownComedyStyleList = ownComedyStyleList;
    }
    /**
     * @return feeTypeList
     */
    public List<String> getFeeTypeList() {
        return feeTypeList;
    }
    /**
     * @param feeTypeList セットする feeTypeList
     */
    public void setFeeTypeList(List<String> feeTypeList) {
        this.feeTypeList = feeTypeList;
    }
    /**
     * @return feeList
     */
    public List<Integer> getFeeList() {
        return feeList;
    }
    /**
     * @param feeList セットする feeList
     */
    public void setFeeList(List<Integer> feeList) {
        this.feeList = feeList;
    }
    /**
     * @return skillList
     */
    public List<SpecialSkill> getSkillList() {
        return skillList;
    }
    /**
     * @param skillList セットする skillList
     */
    public void setSkillList(List<SpecialSkill> skillList) {
        this.skillList = skillList;
    }
    /**
     * @return areaList
     */
    public List<Area> getAreaList() {
        return areaList;
    }
    /**
     * @param areaList セットする areaList
     */
    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}

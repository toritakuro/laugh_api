package com.c4ccup.laugh.controller.bean;

import java.util.List;

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
    private List<String> belongList;
    /** 芸風リスト */
    private List<String> comedyStyleList;
    /** 得意分野リスト */
    private List<String> ownComedyStyleList;
    /** 料金体系リスト */
    private List<String> feeTypeList;
    /** 金額リスト */
    private List<Integer> feeList;
    /** 特殊スキルリスト */
    private List<String> skillList;
    /** 活動場所リスト */
    private List<String> activePlaceList;

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
     * @return belongList
     */
    public List<String> getBelongList() {
        return belongList;
    }
    /**
     * @param belongList セットする belongList
     */
    public void setBelongList(List<String> belongList) {
        this.belongList = belongList;
    }
    /**
     * @return comedyStyleList
     */
    public List<String> getComedyStyleList() {
        return comedyStyleList;
    }
    /**
     * @param comedyStyleList セットする comedyStyleList
     */
    public void setComedyStyleList(List<String> comedyStyleList) {
        this.comedyStyleList = comedyStyleList;
    }
    /**
     * @return ownComedyStyleList
     */
    public List<String> getOwnComedyStyleList() {
        return ownComedyStyleList;
    }
    /**
     * @param ownComedyStyleList セットする ownComedyStyleList
     */
    public void setOwnComedyStyleList(List<String> ownComedyStyleList) {
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
    public List<String> getSkillList() {
        return skillList;
    }
    /**
     * @param skillList セットする skillList
     */
    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
    }
    /**
     * @return activePlaceList
     */
    public List<String> getActivePlaceList() {
        return activePlaceList;
    }
    /**
     * @param activePlaceList セットする activePlaceList
     */
    public void setActivePlaceList(List<String> activePlaceList) {
        this.activePlaceList = activePlaceList;
    }
    


}

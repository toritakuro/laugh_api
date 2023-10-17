package com.c4ccup.laugh.controller.bean.req;

/**
 * マイページBean
 */
public class MyPageBean {

    /** ユーザID */
    private int userId;
    /** ユーザID */
    private int userType;


    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public int getUserId() {
        return userId;
    }
    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public int getUserType() {
        return userType;
    }
    /**
     * ユーザIDを設定します。
     * @param userType ユーザID
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

}

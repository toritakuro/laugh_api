package com.c4ccup.laugh.controller.bean.req;

/**
 * マイページBean
 */
public class MyPageBean {

    /** ユーザID */
    private int userId;
    /** ユーザType */
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
     * ユーザTypeを取得します。
     * @return userType
     */
    public int getUserType() {
        return userType;
    }
    /**
     * ユーザTypeを設定します。
     * @param userType
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

}

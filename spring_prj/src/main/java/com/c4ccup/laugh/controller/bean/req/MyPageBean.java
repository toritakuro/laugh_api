package com.c4ccup.laugh.controller.bean.req;

/**
 * マイページリクエスト
 *
 */
public class MyPageBean {
    /** ユーザID */
    private int userId;

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

}

package com.c4ccup.laugh.controller.bean.req;

/**
 * Top画面Bean
 */
public class TopBean {

    /** ユーザタイプ */
    private int userType;

    /**
     * ユーザタイプを取得します。
     * @return ユーザタイプ
     */
    public int getUserType() {
        return userType;
    }
    /**
     * ユーザタイプを設定します。
     * @param userType ユーザタイプ
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

}

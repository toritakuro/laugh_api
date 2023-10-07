package com.c4ccup.laugh.controller.bean.req;

/**
 * チャットBean
 */
public class ChatBean {

    /** 作家ID */
    private Integer userComposerId;
    /** 芸人ID */
    private Integer userComedianId;


    /**
     * 作家IDを取得します。
     * @return 作家ID
     */
    public Integer getUserComposerId() {
        return userComposerId;
    }
    /**
     * 作家IDを設定します。
     * @param userComposerId 作家ID
     */
    public void setUserComposerId(Integer userComposerId) {
        this.userComposerId = userComposerId;
    }
    /**
     * 芸人IDを取得します。
     * @return 芸人ID
     */
    public Integer getUserComedianId() {
        return userComedianId;
    }
    /**
     * 芸人IDを設定します。
     * @param userComedianId 芸人ID
     */
    public void setUserComedianId(Integer userComedianId) {
        this.userComedianId = userComedianId;
    }

}

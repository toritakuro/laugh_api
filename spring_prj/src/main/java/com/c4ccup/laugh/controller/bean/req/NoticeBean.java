package com.c4ccup.laugh.controller.bean.req;

/**
 * お知らせBean
 */
public class NoticeBean {

    /** お知らせID */
    private int id;
    /** ユーザID */
    private int userId;
    /** お知らせ種別 */
    private int targetType;
    /** 対象ID */
    private int targetId;
    /** 送信元ユーザID */
    private int userIdFrom;



    /**
     * お知らせIDを取得します。
     * @return お知らせID
     */
    public int getId() {
        return id;
    }
    /**
     * お知らせIDを設定します。
     * @param id お知らせID
     */
    public void setId(int id) {
        this.id = id;
    }
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
     * お知らせ種別を取得します。
     * @return お知らせ種別
     */
    public int getTargetType() {
        return targetType;
    }
    /**
     * お知らせ種別を設定します。
     * @param targetType お知らせ種別
     */
    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }
    /**
     * 対象IDを取得します。
     * @return 対象ID
     */
    public int getTargetId() {
        return targetId;
    }
    /**
     * 対象IDを設定します。
     * @param targetId 対象ID
     */
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
    /**
     * 送信元ユーザIDを取得します。
     * @return 送信元ユーザID
     */
    public int getUserIdFrom() {
        return userIdFrom;
    }
    /**
     * 送信元ユーザIDを設定します。
     * @param userIdFrom 送信元ユーザID
     */
    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

}

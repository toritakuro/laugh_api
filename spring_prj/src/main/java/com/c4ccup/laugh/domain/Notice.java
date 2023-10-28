package com.c4ccup.laugh.domain;

public class Notice {

    /** id */
    private int id;
    /** お知らせ種別 */
    private int targetType;
    /** 対象ID */
    private int targetId;
    /** 送信先ユーザー */
    private int targetUserId;
    /** 既読フラグ */
    private int isRead;
    /** メッセージ */
    private String message;



    /**
     * idを取得します。
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * idを設定します。
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
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
     * @param targetTyp お知らせ種別
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
     * 送信先ユーザーを取得します。
     * @return 送信先ユーザー
     */
    public int getTargetUserId() {
        return targetUserId;
    }
    /**
     * 送信先ユーザーを設定します。
     * @param targetUserId 送信先ユーザー
     */
    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }
    /**
     * 既読フラグを取得します。
     * @return 既読フラグ
     */
    public int getIsRead() {
        return isRead;
    }
    /**
     * 既読フラグを設定します。
     * @param isRead 既読フラグ
     */
    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
    /**
     * メッセージを取得します。
     * @return メッセージ
     */
    public String getMessage() {
        return message;
    }
    /**
     * メッセージを設定します。
     * @param message メッセージ
     */
    public void setMessage(String message) {
        this.message = message;
    }

}

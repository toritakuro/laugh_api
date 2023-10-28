package com.c4ccup.laugh.controller.bean.res;

import com.c4ccup.laugh.domain.Notice;

/**
 * お知らせクラス
 */
public class NoticeResource {

    public NoticeResource(Notice notice) {
        this.id =  notice.getId();
        this.targetType =  notice.getTargetType();
        this.targetId =  notice.getTargetId();
        this.message =  notice.getMessage();
    }

    /** ID */
    private int id;
    /** 対象種別 */
    private int targetType;
    /** 対象ID */
    private int targetId;
    /** メッセージ */
    private String message;



    /**
     * IDを取得します。
     * @return ID
     */
    public int getId() {
        return id;
    }
    /**
     * IDを設定します。
     * @param id ID
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 対象種別を取得します。
     * @return 対象種別
     */
    public int getTargetType() {
        return targetType;
    }
    /**
     * 対象種別を設定します。
     * @param targetType 対象種別
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
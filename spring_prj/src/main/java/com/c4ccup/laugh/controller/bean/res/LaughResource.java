package com.c4ccup.laugh.controller.bean.res;

/**
 * LaughResourceクラス
 */
public class LaughResource {

    /** id */
    private int id;
    /** マッチングステータス */
    private int status;
    /** マッチングステータス */
    private String statusStr;
    /** 対象ユーザId */
    private int targetUserId;
    /** 名前 */
    private String name;
    /** 活動歴(年) */
    private  int activeTermYear;
    /** 活動歴(月) */
    private  int activeTermMonth;
    /** 自分が送ったLaughか */
    private boolean isMySendLough;
    /** 画像パス */
    private String imgPath;


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
     * マッチングステータスを取得します。
     * @return マッチングステータス
     */
    public int getStatus() {
        return status;
    }
    /**
     * マッチングステータスを設定します。
     * @param status マッチングステータス
     */
    public void setStatus(int status) {
        this.status = status;
    }
    /**
     * マッチングステータスを取得します。
     * @return マッチングステータス
     */
    public String getStatusStr() {
        return statusStr;
    }
    /**
     * マッチングステータスを設定します。
     * @param statusStr マッチングステータス
     */
    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
    /**
     * 対象ユーザIdを取得します。
     * @return 対象ユーザId
     */
    public int getTargetUserId() {
        return targetUserId;
    }
    /**
     * 対象ユーザIdを設定します。
     * @param targetUserId 対象ユーザId
     */
    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }
    /**
     * 名前を取得します。
     * @return 名前
     */
    public String getName() {
        return name;
    }
    /**
     * 名前を設定します。
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 活動歴(年)を取得します。
     * @return 活動歴(年)
     */
    public int getActiveTermYear() {
        return activeTermYear;
    }
    /**
     * 活動歴(年)を設定します。
     * @param activeTermYear 活動歴(年)
     */
    public void setActiveTermYear(int activeTermYear) {
        this.activeTermYear = activeTermYear;
    }
    /**
     * 活動歴(月)を取得します。
     * @return 活動歴(月)
     */
    public int getActiveTermMonth() {
        return activeTermMonth;
    }
    /**
     * 活動歴(月)を設定します。
     * @param activeTermMonth 活動歴(月)
     */
    public void setActiveTermMonth(int activeTermMonth) {
        this.activeTermMonth = activeTermMonth;
    }
    /**
     * 自分が送ったLaughかを取得します。
     * @return 自分が送ったLaughか
     */
    public boolean isMySendLough() {
        return isMySendLough;
    }
    /**
     * 自分が送ったLaughかを設定します。
     * @param isMySendLough 自分が送ったLaughか
     */
    public void setMySendLough(boolean isMySendLough) {
        this.isMySendLough = isMySendLough;
    }
    /**
     * 画像パスを取得します。
     * @return 画像パス
     */
    public String getImgPath() {
        return imgPath;
    }
    /**
     * 画像パスを設定します。
     * @param imgPath 画像パス
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}

package com.c4ccup.laugh.domain;

import java.time.LocalDate;

public class Laugh {

    /** id */
    private int id;
    /** マッチングステータス */
    private int status;
    /** 送信ユーザID */
    private int sendUserId;
    /** 受信ユーザID */
    private int receiveUserId;
    /** Laugh送信ユーザID */
    private int userIdSend;
    /** Laugh送信ユーザ名 */
    private String userNameSend;
    /** Laugh送信ユーザデビュー年 */
    private LocalDate uerDebutAtSend;
    /** Laugh受信ユーザID */
    private int userIdReceive;
    /** Laugh受信ユーザ名 */
    private String userNameReceive;
    /** Laugh受信ユーザ名 */
    private LocalDate userDebutAtReceive;
    /** 送信画像 */
    private String profileImgPathSend;
    /** 受信画像 */
    private String profileImgPathReceive;


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
     * 送信ユーザIDを取得します。
     * @return 送信ユーザID
     */
    public int getSendUserId() {
        return sendUserId;
    }
    /**
     * 送信ユーザIDを設定します。
     * @param sendUserId 送信ユーザID
     */
    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }
    /**
     * 受信ユーザIDを取得します。
     * @return 受信ユーザID
     */
    public int getReceiveUserId() {
        return receiveUserId;
    }
    /**
     * 受信ユーザIDを設定します。
     * @param receiveUserId 受信ユーザID
     */
    public void setReceiveUserId(int receiveUserId) {
        this.receiveUserId = receiveUserId;
    }
    /**
     * Laugh送信ユーザIDを取得します。
     * @return Laugh送信ユーザID
     */
    public int getUserIdSend() {
        return userIdSend;
    }
    /**
     * Laugh送信ユーザIDを設定します。
     * @param userIdSend Laugh送信ユーザID
     */
    public void setUserIdSend(int userIdSend) {
        this.userIdSend = userIdSend;
    }
    /**
     * Laugh送信ユーザ名を取得します。
     * @return Laugh送信ユーザ名
     */
    public String getUserNameSend() {
        return userNameSend;
    }
    /**
     * Laugh送信ユーザ名を設定します。
     * @param userNameSend Laugh送信ユーザ名
     */
    public void setUserNameSend(String userNameSend) {
        this.userNameSend = userNameSend;
    }
    /**
     * Laugh送信ユーザデビュー年を取得します。
     * @return Laugh送信ユーザデビュー年
     */
    public LocalDate getUerDebutAtSend() {
        return uerDebutAtSend;
    }
    /**
     * Laugh送信ユーザデビュー年を設定します。
     * @param uerDebutAtSend Laugh送信ユーザデビュー年
     */
    public void setUerDebutAtSend(LocalDate uerDebutAtSend) {
        this.uerDebutAtSend = uerDebutAtSend;
    }
    /**
     * Laugh受信ユーザIDを取得します。
     * @return Laugh受信ユーザID
     */
    public int getUserIdReceive() {
        return userIdReceive;
    }
    /**
     * Laugh受信ユーザIDを設定します。
     * @param userIdReceive Laugh受信ユーザID
     */
    public void setUserIdReceive(int userIdReceive) {
        this.userIdReceive = userIdReceive;
    }
    /**
     * Laugh受信ユーザ名を取得します。
     * @return Laugh受信ユーザ名
     */
    public String getUserNameReceive() {
        return userNameReceive;
    }
    /**
     * Laugh受信ユーザ名を設定します。
     * @param userNameReceive Laugh受信ユーザ名
     */
    public void setUserNameReceive(String userNameReceive) {
        this.userNameReceive = userNameReceive;
    }
    /**
     * Laugh受信ユーザ名を取得します。
     * @return Laugh受信ユーザ名
     */
    public LocalDate getUserDebutAtReceive() {
        return userDebutAtReceive;
    }
    /**
     * Laugh受信ユーザ名を設定します。
     * @param userDebutAtReceive Laugh受信ユーザ名
     */
    public void setUserDebutAtReceive(LocalDate userDebutAtReceive) {
        this.userDebutAtReceive = userDebutAtReceive;
    }
    /**
     * 送信画像を取得します。
     * @return 送信画像
     */
    public String getProfileImgPathSend() {
        return profileImgPathSend;
    }
    /**
     * 送信画像を設定します。
     * @param profileImgPathSend 送信画像
     */
    public void setProfileImgPathSend(String profileImgPathSend) {
        this.profileImgPathSend = profileImgPathSend;
    }
    /**
     * 受信画像を取得します。
     * @return 受信画像
     */
    public String getProfileImgPathReceive() {
        return profileImgPathReceive;
    }
    /**
     * 受信画像を設定します。
     * @param profileImgPathReceive 受信画像
     */
    public void setProfileImgPathReceive(String profileImgPathReceive) {
        this.profileImgPathReceive = profileImgPathReceive;
    }

}

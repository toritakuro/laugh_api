package com.c4ccup.laugh.controller.bean.req;

import java.util.Base64;

/**
 * マイページBean
 */
public class MyPageBean {

    /** ユーザID */
    private int userId;

    // contentテーブル用
    /** ID */
    private int id;
    /** タイトル */
    private String title;
    /** 詳細 */
    private String detail;
    /** サムネイル画像 */
    private String topImg;
    /** サムネイル画像URL */
    private String topImgPath;
    /** コンテント */
    private String content;
    /** コンテントURL */
    private String contentPath;



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
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id セットする id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * タイトルを取得します。
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * タイトルを設定します。
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 詳細を取得します。
     * @return detail
     */
    public String getDetail() {
        return detail;
    }
    /**
     * 詳細を設定します。
     * @param detail 詳細
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
    /**
     * サムネイル画像を取得します。
     * @return topImg
     */
    public String getTopImg() {
        return topImg;
    }
    /**
     * サムネイル画像を設定します。
     * @param topImg サムネイル画像
     */
    public void setTopImg(String topImg) {
        this.topImg = topImg;
    }
    /**
     * サムネイル画像URLを取得します。
     * @return topImgPath
     */
    public String getTopImgPath() {
        return topImgPath;
    }
    /**
     * サムネイル画像URLを設定します。
     * @param topImgPath サムネイル画像URL
     */
    public void setTopImgPath(String topImgPath) {
        this.topImgPath = topImgPath;
    }
    /**
     * 投稿ファイルを取得します。
     * @return content
     */
    public String getContent() {
        return content;
//        if(content != null) {
//            return Base64.getEncoder().encodeToString(content);
//        }
//        return null;
    }
    /**
     * 投稿ファイルを設定します。
     * @param content 投稿ファイル
     */
    public void setContent(String content) {
        this.content = content;
//        if(content != null) {
//            this.content = Base64.getDecoder().decode(content);
//            return;
//        }
//        this.content = null;
    }
    /**
     * 投稿ファイルURLを取得します。
     * @return contentPath
     */
    public String getContentPath() {
        return contentPath;
    }
    /**
     * 投稿ファイルURLを設定します。
     * @param contentPath 投稿ファイルURL
     */
    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

}

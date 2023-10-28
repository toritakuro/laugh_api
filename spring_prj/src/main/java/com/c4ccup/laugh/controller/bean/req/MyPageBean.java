package com.c4ccup.laugh.controller.bean.req;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

/**
 * マイページBean
 */
public class MyPageBean {

    /** ユーザID */
    private int userId;
    /** ユーザTYPE */
    private int userType;

    // contentテーブル用
    /** ID */
    private int id;
    @NotEmpty
    /** タイトル */
    private String title;
    /** 詳細 */
    private String detail;
    /** ファイル種類 */
    private int fileType;
    @NotEmpty
    /** コンテント */
    private String content;
    /** コンテントURL */
    private String contentPath;
    /** 更新日時 */
    private LocalDateTime updateAt;



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
     * idを取得します。
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
     * ファイル種類を取得します。
     * @return topImg
     */
    public int getFileType() {
        return fileType;
    }
    /**
     * ファイル種類を設定します。
     * @param topImg ファイル種類
     */
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
    /**
     * 投稿ファイルを取得します。
     * @return content
     */
    public String getContent() {
        return content;
    }
    /**
     * 投稿ファイルを設定します。
     * @param content 投稿ファイル
     */
    public void setContent(String content) {
        this.content = content;
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
    /**
     * ユーザTYPEを取得します。
     * @return ユーザTYPE
     */
    public int getUserType() {
        return userType;
    }
    /**
     * ユーザTYPEを設定します。
     * @param userType ユーザTYPE
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }
    /**
     * 更新日時を取得します。
     * @return updateAt 更新日時
     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    /**
     * 更新日時を設定します。
     * @param updateAt 更新日時
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}

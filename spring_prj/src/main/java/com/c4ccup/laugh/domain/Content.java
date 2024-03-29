package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class Content {

    /** ID */
    private int id;
    /** ユーザID */
    private int userId;
    /** タイトル */
    private String title;
    /** 詳細 */
    private String detail;
    /** ファイル種類 */
    private int fileType;
    /** コンテントURL */
    private String contentPath;
    /** 作成日時 */
    private LocalDateTime createAt;
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
     * @return topImgPath
     */
    public int getFileType() {
        return fileType;
    }
    /**
     * ファイル種類を設定します。
     * @param topImgPath サムネイル画像URL
     */
    public void setFileType(int fileType) {
        this.fileType = fileType;
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
     * 作成日時を取得する
     * @return 作成日時
     */
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    /**
     * 作成日時を設定する
     * @param createAt 作成日時
     */
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    /**
     * 更新日時を取得する
     * @return 更新日時
     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    /**
     * 更新日時を設定する
     * @param updateAt 更新日時
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}

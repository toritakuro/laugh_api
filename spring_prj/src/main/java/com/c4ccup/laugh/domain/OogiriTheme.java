package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 大喜利お題テーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 *
 */
public class OogiriTheme {
    /** お題ID */
    private int themeId;
    /** お題ユーザーID */
    private int themeUserId;
    /** お題内容 */
    private String themeContent;
    /** お題作成日時 */
    private LocalDateTime themeCreatedAt;
    /** お題更新日時 */
    private LocalDateTime themeUpdatedAt;

    /** 回答リスト */
    private List<OogiriAnswer> answers;

    /**
     * お題IDを取得
     * 
     * @return themeId
     */
    public int getThemeId() {
        return themeId;
    }

    /**
     * @param themeId セットする お題ID
     */
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    /**
     * お題ユーザーIDを取得
     * 
     * @return themeUserId
     */
    public int getThemeUserId() {
        return themeUserId;
    }

    /**
     * @param themeUserId セットする お題ユーザーID
     */
    public void setThemeUserId(int themeUserId) {
        this.themeUserId = themeUserId;
    }

    /**
     * お題内容を取得
     * 
     * @return themeContent
     */
    public String getThemeContent() {
        return themeContent;
    }

    /**
     * @param themeContent セットする お題内容
     */
    public void setThemeContent(String themeContent) {
        this.themeContent = themeContent;
    }

    /**
     * お題作成日時を取得
     * 
     * @return themeCreatedAt
     */
    public LocalDateTime getThemeCreatedAt() {
        return themeCreatedAt;
    }

    /**
     * @param themeCreatedAt セットする お題作成日時
     */
    public void setThemeCreatedAt(LocalDateTime themeCreatedAt) {
        this.themeCreatedAt = themeCreatedAt;
    }

    /**
     * お題更新日時を取得
     * 
     * @return themeUpdatedAt
     */
    public LocalDateTime getThemeUpdatedAt() {
        return themeUpdatedAt;
    }

    /**
     * @param themeUpdatedAt セットする お題更新日時
     */
    public void setThemeUpdatedAt(LocalDateTime themeUpdatedAt) {
        this.themeUpdatedAt = themeUpdatedAt;
    }

    /**
     * 回答リストを取得
     * 
     * @return answers
     */
    public List<OogiriAnswer> getAnswers() {
        return answers;
    }

    /**
     * @param answers セットする 回答リスト
     */
    public void setAnswers(List<OogiriAnswer> answers) {
        this.answers = answers;
    }

}
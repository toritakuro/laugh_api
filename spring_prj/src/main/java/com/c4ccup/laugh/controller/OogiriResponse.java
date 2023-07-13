package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.c4ccup.laugh.domain.OogiriTheme;

/**
 * 大喜利関連 レスポンスクラス
 *
 */
public class OogiriResponse {

    // お題情報
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

    // 回答情報
    /** 回答リスト */
    private List<OogiriAnswerResponse> answers;

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
    public List<OogiriAnswerResponse> getAnswers() {
        return answers;
    }

    /**
     * @param answers セットする 回答リスト
     */
    public void setAnswers(List<OogiriAnswerResponse> answers) {
        this.answers = answers;
    }

    /**
     * 大喜利レスポンスを生成
     * 
     * @param theme   お題
     * @param answers 回答リスト
     * @return 大喜利レスポンス
     */
    public static OogiriResponse themeAndAnswers(OogiriTheme theme, List<OogiriAnswerResponse> answers) {
        OogiriResponse response = new OogiriResponse();
        response.setThemeId(theme.getThemeId());
        response.setThemeUserId(theme.getThemeUserId());
        response.setThemeContent(theme.getThemeContent());
        response.setThemeCreatedAt(theme.getThemeCreatedAt());
        response.setThemeUpdatedAt(theme.getThemeUpdatedAt());
        response.setAnswers(answers);
        return response;
    }

    /**
     * 大喜利詳細レスポンスを生成
     * 
     * @param theme   お題
     * @param answers 回答リスト
     * @return 大喜利詳細レスポンス
     */
    public static OogiriResponse oogiriDetails(OogiriTheme theme, List<OogiriAnswerResponse> answers) {
        OogiriResponse response = new OogiriResponse();
        response.setThemeId(theme.getThemeId());
        response.setThemeUserId(theme.getThemeUserId());
        response.setThemeContent(theme.getThemeContent());
        response.setThemeCreatedAt(theme.getThemeCreatedAt());
        response.setThemeUpdatedAt(theme.getThemeUpdatedAt());
        response.setAnswers(answers);
        return response;
    }

    /**
     * エラーレスポンスを生成
     * 
     * @param errorCode    エラーコード
     * @param errorMessage エラーメッセージ
     * @return
     */
    public static OogiriResponse errorResponse(int errorCode, String errorMessage) {
        OogiriResponse response = new OogiriResponse();
        return response;
    }
}
package com.c4ccup.laugh.controller;

import java.util.List;

public class OogiriRequest {

    /** ユーザーID */
    private int userId;

    // お題情報
    /** お題ID */
    private int themeId;
    /** お題ユーザーID */
    private int themeUserId;
    /** お題内容 */
    private String themeContent;

    // 回答情報
    /** 回答ID */
    private int answerId;
    /** 回答内容 */
    private String answerContent;
    /** 回答リスト */
    private List<OogiriAnswerResponse> answers;

    // リアクション情報
    /** リアクションID */
    private int reactionId;
    /** リアクションユーザーID */
    private int reactionUserId;
    /** リアクションステータス */
    private int reactionStatus;

    /**
     * ユーザーIDを取得します。
     * 
     * @return ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを設定します。
     * 
     * @param userId ユーザーID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * お題IDを取得します。
     * 
     * @return お題ID
     */
    public int getThemeId() {
        return themeId;
    }

    /**
     * お題IDを設定します。
     * 
     * @param themeId お題ID
     */
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    /**
     * お題ユーザーIDを取得します。
     * 
     * @return お題ユーザーID
     */
    public int getThemeUserId() {
        return themeUserId;
    }

    /**
     * お題ユーザーIDを設定します。
     * 
     * @param themeUserId お題ユーザーID
     */
    public void setThemeUserId(int themeUserId) {
        this.themeUserId = themeUserId;
    }

    /**
     * お題内容を取得します。
     * 
     * @return お題内容
     */
    public String getThemeContent() {
        return themeContent;
    }

    /**
     * お題内容を設定します。
     * 
     * @param themeContent お題内容
     */
    public void setThemeContent(String themeContent) {
        this.themeContent = themeContent;
    }

    /**
     * 回答IDを取得します。
     * 
     * @return 回答ID
     */
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 回答IDを設定します。
     * 
     * @param answerId 回答ID
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 回答内容を取得します。
     * 
     * @return 回答内容
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * 回答内容を設定します。
     * 
     * @param answerContent 回答内容
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    /**
     * 回答リストを取得します。
     * 
     * @return 回答リスト
     */
    public List<OogiriAnswerResponse> getAnswers() {
        return answers;
    }

    /**
     * 回答リストを設定します。
     * 
     * @param answers 回答リスト
     */
    public void setAnswers(List<OogiriAnswerResponse> answers) {
        this.answers = answers;
    }

    /**
     * リアクションIDを取得します。
     * 
     * @return リアクションID
     */
    public int getReactionId() {
        return reactionId;
    }

    /**
     * リアクションIDを設定します。
     * 
     * @param reactionId リアクションID
     */
    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
    }

    /**
     * リアクションユーザーIDを取得します。
     * 
     * @return リアクションユーザーID
     */
    public int getReactionUserId() {
        return reactionUserId;
    }

    /**
     * リアクションユーザーIDを設定します。
     * 
     * @param reactionUserId リアクションユーザーID
     */
    public void setReactionUserId(int reactionUserId) {
        this.reactionUserId = reactionUserId;
    }

    /**
     * リアクションステータスを取得します。
     * 
     * @return リアクションステータス
     */
    public int getReactionStatus() {
        return reactionStatus;
    }

    /**
     * リアクションステータスを設定します。
     * 
     * @param reactionStatus リアクションステータス
     */
    public void setReactionStatus(int reactionStatus) {
        this.reactionStatus = reactionStatus;
    }

}

package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

/**
 * 大喜利回答テーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 *
 */
public class OogiriAnswer {
    /** 回答ID */
    private int answerId;
    /** 回答投稿ユーザーID */
    private int answerUserId;
    /** 回答内容 */
    private String answerContent;
    /** 回答作成日時 */
    private LocalDateTime answerCreatedAt;
    /** 回答削除日時 */
    private LocalDateTime answerDeletedAt;

    /**
     * 回答IDを取得
     * 
     * @return answerId
     */
    public int getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId セットする 回答ID
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 回答ユーザーIDを取得
     * 
     * @return answerUserId
     */
    public int getAnswerUserId() {
        return answerUserId;
    }

    /**
     * @param answerUserId セットする 回答ユーザーID
     */
    public void setAnswerUserId(int answerUserId) {
        this.answerUserId = answerUserId;
    }

    /**
     * 回答内容を取得
     * 
     * @return answerContent
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * @param answerContent セットする 回答内容
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    /**
     * 回答作成日時を取得
     * 
     * @return answerCreatedAt
     */
    public LocalDateTime getAnswerCreatedAt() {
        return answerCreatedAt;
    }

    /**
     * @param answerCreatedAt セットする 回答作成日時
     */
    public void setAnswerCreatedAt(LocalDateTime answerCreatedAt) {
        this.answerCreatedAt = answerCreatedAt;
    }

    /**
     * 回答削除日時を取得
     * 
     * @return answerDeletedAt
     */
    public LocalDateTime getAnswerDeletedAt() {
        return answerDeletedAt;
    }

    /**
     * @param answerDeletedAt セットする 回答削除日時
     */
    public void setAnswerDeletedAt(LocalDateTime answerDeletedAt) {
        this.answerDeletedAt = answerDeletedAt;
    }

}
package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 大喜利回答 レスポンスクラス
 *
 */
public class OogiriAnswerResponse {

    /** 回答ID */
    private int answerId;
    /** 回答ユーザーID */
    private int answerUserId;
    /** 回答内容 */
    private String answerContent;
    /** 回答作成日時 */
    private LocalDateTime answerCreatedAt;

    /** リアクションリスト */
    private List<OogiriReactionResponse> reactions;

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
     * リアクションリストを取得
     * 
     * @return reactions
     */
    public List<OogiriReactionResponse> getReactions() {
        return reactions;
    }

    /**
     * @param reactions セットする リアクションリスト
     */
    public void setReactions(List<OogiriReactionResponse> reactions) {
        this.reactions = reactions;
    }

    public OogiriAnswerResponse() {
        this.reactions = new ArrayList<>();
    }

}

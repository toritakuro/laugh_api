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
    /** 回答ユーザーネーム */
    private String answerUserName;
    /** 回答内容 */
    private String answerContent;
    /** 回答作成日時 */
    private LocalDateTime answerCreatedAt;
    /** 回答削除日時 */
    private LocalDateTime answerDeletedAt;

    /** リアクションリスト */
    private List<OogiriReactionResponse> reactions;

    /**
     * 回答IDを取得します。
     * @return 回答ID
     */
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 回答IDを設定します。
     * @param answerId 回答ID
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 回答ユーザーIDを取得します。
     * @return 回答ユーザーID
     */
    public int getAnswerUserId() {
        return answerUserId;
    }

    /**
     * 回答ユーザーIDを設定します。
     * @param answerUserId 回答ユーザーID
     */
    public void setAnswerUserId(int answerUserId) {
        this.answerUserId = answerUserId;
    }

    /**
     * 回答ユーザーネームを取得します。
     * @return 回答ユーザーネーム
     */
    public String getAnswerUserName() {
        return answerUserName;
    }

    /**
     * 回答ユーザーネームを設定します。
     * @param answerUserName 回答ユーザーネーム
     */
    public void setAnswerUserName(String answerUserName) {
        this.answerUserName = answerUserName;
    }

    public OogiriAnswerResponse() {
        this.reactions = new ArrayList<>();
    }

    /**
     * 回答内容を取得します。
     * @return 回答内容
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * 回答内容を設定します。
     * @param answerContent 回答内容
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    /**
     * 回答作成日時を取得します。
     * @return 回答作成日時
     */
    public LocalDateTime getAnswerCreatedAt() {
        return answerCreatedAt;
    }

    /**
     * 回答作成日時を設定します。
     * @param answerCreatedAt 回答作成日時
     */
    public void setAnswerCreatedAt(LocalDateTime answerCreatedAt) {
        this.answerCreatedAt = answerCreatedAt;
    }

    /**
     * 回答削除日時を取得します。
     * @return 回答削除日時
     */
    public LocalDateTime getAnswerDeletedAt() {
        return answerDeletedAt;
    }

    /**
     * 回答削除日時を設定します。
     * @param answerDeletedAt 回答削除日時
     */
    public void setAnswerDeletedAt(LocalDateTime answerDeletedAt) {
        this.answerDeletedAt = answerDeletedAt;
    }

    /**
     * リアクションリストを取得します。
     * @return リアクションリスト
     */
    public List<OogiriReactionResponse> getReactions() {
        return reactions;
    }

    /**
     * リアクションリストを設定します。
     * @param reactions リアクションリスト
     */
    public void setReactions(List<OogiriReactionResponse> reactions) {
        this.reactions = reactions;
    }

}

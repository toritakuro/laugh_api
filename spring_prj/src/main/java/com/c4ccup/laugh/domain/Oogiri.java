package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.c4ccup.laugh.controller.OogiriAnswerResponse;

public class Oogiri {

    // お題情報
    /** お題ID */
    private int themeId;
    /** お題ユーザーID */
    private int themeUserId;
    /** お題ユーザーネーム */
    private String themeUserName;
    /** お題内容 */
    private String themeContent;
    /** お題作成日時 */
    private LocalDateTime themeCreatedAt;
    /** お題更新日時 */
    private LocalDateTime themeUpdatedAt;

    // 回答情報
    /** 回答ID */
    private int answerId;
    /** 回答投稿ユーザーID */
    private int answerUserId;
    /** 回答ユーザーネーム */
    private String answerUserName;
    /** 回答内容 */
    private String answerContent;
    /** 回答作成日時 */
    private LocalDateTime answerCreatedAt;
    /** 回答削除日時 */
    private LocalDateTime answerDeletedAt;
    /** 回答リスト */
    private List<OogiriAnswerResponse> answers;

    // リアクション情報
    /** リアクションID */
    private int reactionId;
    /** リアクションIDリスト(文字列) */
    private String reactionIds;
    /** リアクションユーザーID */
    private int reactionUserId;
    /** リアクションユーザーIDリスト(文字列) */
    private String reactionUserIds;
    /** リアクションステータス */
    private int reactionStatus;
    /** リアクションステータスリスト（文字列） */
    private String reactionStatuses;
    /** リアクション作成日時 */
    private LocalDateTime reactionCreatedAt;
    /** リアクション更新日時 */
    private LocalDateTime reactionUpdatedAt;
    /** リアクション数 */
    private int reactionNum;

    /**
     * お題IDを取得します。
     * @return お題ID
     */
    public int getThemeId() {
        return themeId;
    }

    /**
     * お題IDを設定します。
     * @param themeId お題ID
     */
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    /**
     * お題ユーザーIDを取得します。
     * @return お題ユーザーID
     */
    public int getThemeUserId() {
        return themeUserId;
    }

    /**
     * お題ユーザーIDを設定します。
     * @param themeUserId お題ユーザーID
     */
    public void setThemeUserId(int themeUserId) {
        this.themeUserId = themeUserId;
    }

    /**
     * お題ユーザーネームを取得します。
     * @return お題ユーザーネーム
     */
    public String getThemeUserName() {
        return themeUserName;
    }

    /**
     * お題ユーザーネームを設定します。
     * @param themeUserName お題ユーザーネーム
     */
    public void setThemeUserName(String themeUserName) {
        this.themeUserName = themeUserName;
    }

    /**
     * お題内容を取得します。
     * @return お題内容
     */
    public String getThemeContent() {
        return themeContent;
    }

    /**
     * お題内容を設定します。
     * @param themeContent お題内容
     */
    public void setThemeContent(String themeContent) {
        this.themeContent = themeContent;
    }

    /**
     * お題作成日時を取得します。
     * @return お題作成日時
     */
    public LocalDateTime getThemeCreatedAt() {
        return themeCreatedAt;
    }

    /**
     * お題作成日時を設定します。
     * @param themeCreatedAt お題作成日時
     */
    public void setThemeCreatedAt(LocalDateTime themeCreatedAt) {
        this.themeCreatedAt = themeCreatedAt;
    }

    /**
     * お題更新日時を取得します。
     * @return お題更新日時
     */
    public LocalDateTime getThemeUpdatedAt() {
        return themeUpdatedAt;
    }

    /**
     * お題更新日時を設定します。
     * @param themeUpdatedAt お題更新日時
     */
    public void setThemeUpdatedAt(LocalDateTime themeUpdatedAt) {
        this.themeUpdatedAt = themeUpdatedAt;
    }

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
     * 回答投稿ユーザーIDを取得します。
     * @return 回答投稿ユーザーID
     */
    public int getAnswerUserId() {
        return answerUserId;
    }

    /**
     * 回答投稿ユーザーIDを設定します。
     * @param answerUserId 回答投稿ユーザーID
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
     * 回答リストを取得します。
     * @return 回答リスト
     */
    public List<OogiriAnswerResponse> getAnswers() {
        return answers;
    }

    /**
     * 回答リストを設定します。
     * @param answers 回答リスト
     */
    public void setAnswers(List<OogiriAnswerResponse> answers) {
        this.answers = answers;
    }

    /**
     * リアクションIDを取得します。
     * @return リアクションID
     */
    public int getReactionId() {
        return reactionId;
    }

    /**
     * リアクションIDを設定します。
     * @param reactionId リアクションID
     */
    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
    }

    /**
     * リアクションIDリスト(文字列)を取得します。
     * @return リアクションIDリスト(文字列)
     */
    public String getReactionIds() {
        return reactionIds;
    }

    /**
     * リアクションIDリスト(文字列)を設定します。
     * @param reactionIds リアクションIDリスト(文字列)
     */
    public void setReactionIds(String reactionIds) {
        this.reactionIds = reactionIds;
    }

    /**
     * リアクションユーザーIDを取得します。
     * @return リアクションユーザーID
     */
    public int getReactionUserId() {
        return reactionUserId;
    }

    /**
     * リアクションユーザーIDを設定します。
     * @param reactionUserId リアクションユーザーID
     */
    public void setReactionUserId(int reactionUserId) {
        this.reactionUserId = reactionUserId;
    }

    /**
     * リアクションユーザーIDリスト(文字列)を取得します。
     * @return リアクションユーザーIDリスト(文字列)
     */
    public String getReactionUserIds() {
        return reactionUserIds;
    }

    /**
     * リアクションユーザーIDリスト(文字列)を設定します。
     * @param reactionUserIds リアクションユーザーIDリスト(文字列)
     */
    public void setReactionUserIds(String reactionUserIds) {
        this.reactionUserIds = reactionUserIds;
    }

    /**
     * リアクションステータスを取得します。
     * @return リアクションステータス
     */
    public int getReactionStatus() {
        return reactionStatus;
    }

    /**
     * リアクションステータスを設定します。
     * @param reactionStatus リアクションステータス
     */
    public void setReactionStatus(int reactionStatus) {
        this.reactionStatus = reactionStatus;
    }

    /**
     * リアクションステータスリスト（文字列）を取得します。
     * @return リアクションステータスリスト（文字列）
     */
    public String getReactionStatuses() {
        return reactionStatuses;
    }

    /**
     * リアクションステータスリスト（文字列）を設定します。
     * @param reactionStatuses リアクションステータスリスト（文字列）
     */
    public void setReactionStatuses(String reactionStatuses) {
        this.reactionStatuses = reactionStatuses;
    }

    /**
     * リアクション作成日時を取得します。
     * @return リアクション作成日時
     */
    public LocalDateTime getReactionCreatedAt() {
        return reactionCreatedAt;
    }

    /**
     * リアクション作成日時を設定します。
     * @param reactionCreatedAt リアクション作成日時
     */
    public void setReactionCreatedAt(LocalDateTime reactionCreatedAt) {
        this.reactionCreatedAt = reactionCreatedAt;
    }

    /**
     * リアクション更新日時を取得します。
     * @return リアクション更新日時
     */
    public LocalDateTime getReactionUpdatedAt() {
        return reactionUpdatedAt;
    }

    /**
     * リアクション更新日時を設定します。
     * @param reactionUpdatedAt リアクション更新日時
     */
    public void setReactionUpdatedAt(LocalDateTime reactionUpdatedAt) {
        this.reactionUpdatedAt = reactionUpdatedAt;
    }

    /**
     * リアクション数を取得します。
     * @return リアクション数
     */
    public int getReactionNum() {
        return reactionNum;
    }

    /**
     * リアクション数を設定します。
     * @param reactionNum リアクション数
     */
    public void setReactionNum(int reactionNum) {
        this.reactionNum = reactionNum;
    }

}

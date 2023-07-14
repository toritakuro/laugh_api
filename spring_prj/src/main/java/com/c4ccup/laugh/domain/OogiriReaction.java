package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

/**
 * 大喜利リアクションテーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 *
 */
public class OogiriReaction {

    /** リアクションID */
    private int reactionId;
    /** リアクションユーザーID */
    private int reactionUserId;
    /** リアクションステータス */
    private int reactionStatus;
    /** リアクション作成日時 */
    private LocalDateTime reactionCreatedAt;
    /** リアクション更新日時 */
    private LocalDateTime reactionUpdatedAt;

    /**
     * リアクションIDを取得
     * 
     * @return reactionId
     */
    public int getReactionId() {
        return reactionId;
    }

    /**
     * @param reactionId セットする リアクションID
     */
    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
    }

    /**
     * リアクションユーザーIDを取得
     * 
     * @return reactionUserId
     */
    public int getReactionUserId() {
        return reactionUserId;
    }

    /**
     * @param reactionUserId セットする リアクションユーザーID
     */
    public void setReactionUserId(int reactionUserId) {
        this.reactionUserId = reactionUserId;
    }

    /**
     * リアクションステータスを取得
     * 
     * @return reactionStatus
     */
    public int getReactionStatus() {
        return reactionStatus;
    }

    /**
     * @param reactionStatus セットする リアクションステータス
     */
    public void setReactionStatus(int reactionStatus) {
        this.reactionStatus = reactionStatus;
    }

    /**
     * リアクション作成日時を取得
     * 
     * @return reactionCreatedAt
     */
    public LocalDateTime getReactionCreatedAt() {
        return reactionCreatedAt;
    }

    /**
     * @param reactionCreatedAt セットする リアクション作成日時
     */
    public void setReactionCreatedAt(LocalDateTime reactionCreatedAt) {
        this.reactionCreatedAt = reactionCreatedAt;
    }

    /**
     * リアクション更新日時を取得
     * 
     * @return reactionUpdatedAt
     */
    public LocalDateTime getReactionUpdatedAt() {
        return reactionUpdatedAt;
    }

    /**
     * @param reactionUpdatedAt セットする リアクション更新日時
     */
    public void setReactionUpdatedAt(LocalDateTime reactionUpdatedAt) {
        this.reactionUpdatedAt = reactionUpdatedAt;
    }

}
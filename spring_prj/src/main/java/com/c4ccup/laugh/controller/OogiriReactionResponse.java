package com.c4ccup.laugh.controller;

/**
 * 大喜利リアクション レスポンスクラス
 *
 */
public class OogiriReactionResponse {

    /** リアクションID */
    private int reactionId;
    /** リアクションユーザーID */
    private int reactionUserId;
    /** リアクションステータス */
    private int reactionStatus;

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

}

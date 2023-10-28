package com.c4ccup.laugh.controller.bean.res;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OogiriAnswerResources {

    public OogiriAnswerResources() {
        this.reactions = new ArrayList<>();
    }

    /** 回答ID */
    private int answerId;
    /** 回答ユーザーID */
    private int answerUserId;
    /** 回答ユーザーネーム */
    private String answerUserName;
    /** プロフィール画像 */
    private String img;
    /** ユーザータイプ */
    private int userType;
    /** 回答内容 */
    private String answerContent;
    /** 回答作成日時 */
    private LocalDateTime answerCreatedAt;
    /** 回答削除日時 */
    private LocalDateTime answerDeletedAt;

    /** リアクションリスト */
    private List<OogiriReactionResources> reactions;

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
     * 回答ユーザーIDを取得します。
     * 
     * @return 回答ユーザーID
     */
    public int getAnswerUserId() {
        return answerUserId;
    }

    /**
     * 回答ユーザーIDを設定します。
     * 
     * @param answerUserId 回答ユーザーID
     */
    public void setAnswerUserId(int answerUserId) {
        this.answerUserId = answerUserId;
    }

    /**
     * 回答ユーザーネームを取得します。
     * 
     * @return 回答ユーザーネーム
     */
    public String getAnswerUserName() {
        return answerUserName;
    }

    /**
     * 回答ユーザーネームを設定します。
     * 
     * @param answerUserName 回答ユーザーネーム
     */
    public void setAnswerUserName(String answerUserName) {
        this.answerUserName = answerUserName;
    }

    /**
     * プロフィール画像を取得します。
     * 
     * @return プロフィール画像
     */
    public String getImg() {
        return img;
    }

    /**
     * プロフィール画像を設定します。
     * 
     * @param img プロフィール画像
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * ユーザータイプを取得します。
     * @return ユーザータイプ
     */
    public int getUserType() {
        return userType;
    }

    /**
     * ユーザータイプを設定します。
     * @param userType ユーザータイプ
     */
    public void setUserType(int userType) {
        this.userType = userType;
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
     * 回答作成日時を取得します。
     * 
     * @return 回答作成日時
     */
    public LocalDateTime getAnswerCreatedAt() {
        return answerCreatedAt;
    }

    /**
     * 回答作成日時を設定します。
     * 
     * @param answerCreatedAt 回答作成日時
     */
    public void setAnswerCreatedAt(LocalDateTime answerCreatedAt) {
        this.answerCreatedAt = answerCreatedAt;
    }

    /**
     * 回答削除日時を取得します。
     * 
     * @return 回答削除日時
     */
    public LocalDateTime getAnswerDeletedAt() {
        return answerDeletedAt;
    }

    /**
     * 回答削除日時を設定します。
     * 
     * @param answerDeletedAt 回答削除日時
     */
    public void setAnswerDeletedAt(LocalDateTime answerDeletedAt) {
        this.answerDeletedAt = answerDeletedAt;
    }

    /**
     * リアクションリストを取得します。
     * 
     * @return リアクションリスト
     */
    public List<OogiriReactionResources> getReactions() {
        return reactions;
    }

    /**
     * リアクションリストを設定します。
     * 
     * @param reactions リアクションリスト
     */
    public void setReactions(List<OogiriReactionResources> reactions) {
        this.reactions = reactions;
    }

}

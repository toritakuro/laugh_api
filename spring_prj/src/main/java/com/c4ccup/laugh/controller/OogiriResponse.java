package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.c4ccup.laugh.domain.Oogiri;
import com.c4ccup.laugh.util.Util;

/**
 * 大喜利関連 レスポンスクラス
 *
 */
public class OogiriResponse {

    public OogiriResponse() {

    }

    /**
     * 大喜利詳細用コンストラクタ
     * 
     * @param oogiriList
     */
    public OogiriResponse(List<Oogiri> oogiriList) {
        this.setThemeInfo(oogiriList);
        this.setAnswerInfo(oogiriList);
    }

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
    /** 回答リスト */
    private List<OogiriAnswerResponse> answers;

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
     * お題ユーザーネームを取得します。
     * 
     * @return お題ユーザーネーム
     */
    public String getThemeUserName() {
        return themeUserName;
    }

    /**
     * お題ユーザーネームを設定します。
     * 
     * @param themeUserName お題ユーザーネーム
     */
    public void setThemeUserName(String themeUserName) {
        this.themeUserName = themeUserName;
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
     * お題情報をセットする（詳細用）
     * 
     * @param oogiriRes
     * @param responses
     * @return
     */
    private void setThemeInfo(List<Oogiri> oogiriList) {
        Oogiri oogiri = oogiriList.get(0);
        this.themeId = oogiri.getThemeId();
        this.themeUserId = oogiri.getThemeUserId();
        this.themeUserName = oogiri.getThemeUserName();
        this.themeContent = oogiri.getThemeContent();
        this.themeCreatedAt = oogiri.getThemeCreatedAt();
    }

    /**
     * 回答情報をセットする（詳細用）
     * 
     * @param oogiriRes
     * @param responses
     * @return
     */
    private void setAnswerInfo(List<Oogiri> oogiriList) {
        this.answers = new ArrayList<>();
        // 回答情報を詰めていく
        for (Oogiri oogiri : oogiriList) {
            OogiriAnswerResponse ansRes = new OogiriAnswerResponse();
            List<OogiriReactionResponse> oogiriReacResList = new ArrayList<>();
            ansRes.setAnswerId(oogiri.getAnswerId());
            ansRes.setAnswerUserId(oogiri.getAnswerUserId());
            ansRes.setAnswerUserName(oogiri.getAnswerUserName());
            ansRes.setAnswerContent(oogiri.getAnswerContent());
            ansRes.setAnswerCreatedAt(oogiri.getAnswerCreatedAt());
            ansRes.setAnswerDeletedAt(oogiri.getAnswerDeletedAt());
            // 回答に紐づくリアクションを取得
            oogiriReacResList = setReacInfo(oogiri, oogiriReacResList);
            ansRes.setReactions(oogiriReacResList);
            this.answers.add(ansRes);
        }
    }

    /**
     * リアクション情報をセットする
     * 
     * @param res
     * @param oogiriReacResList
     * @return
     */
    private List<OogiriReactionResponse> setReacInfo(Oogiri res, List<OogiriReactionResponse> oogiriReacResList) {
        // リアクション情報がない場合、終了
        if (res.getReactionIds() == null)
            return oogiriReacResList;
        // 文字列を分割し配列に格納
        String[] reactionIdStrList = res.getReactionIds().split(","); // リアクションID
        String[] reactionUserIdStrList = res.getReactionUserIds().split(","); // リアクションユーザーID
        String[] reactionStatusStrList = res.getReactionStatuses().split(","); // リアクションステータス
        // int型に変換
        List<Integer> ids = Util.chgToInt(reactionIdStrList);
        List<Integer> userIds = Util.chgToInt(reactionUserIdStrList);
        List<Integer> statuses = Util.chgToInt(reactionStatusStrList);
        // リアクションリストに追加
        for (int i = 0; i < ids.size(); i++) {
            OogiriReactionResponse oogiriReacRes = new OogiriReactionResponse();
            oogiriReacRes.setReactionId(ids.get(i));
            oogiriReacRes.setReactionUserId(userIds.get(i));
            oogiriReacRes.setReactionStatus(statuses.get(i));
            oogiriReacResList.add(oogiriReacRes);
        }
        return oogiriReacResList;
    }

    /**
     * お題情報をセットする（初期表示時用）
     * 
     * @param o
     * @return
     */
    public OogiriResponse setThemeInfo(Oogiri o) {
        this.setThemeId(o.getThemeId());
        this.setThemeUserId(o.getThemeUserId());
        this.setThemeContent(o.getThemeContent());
        this.setThemeUpdatedAt(o.getThemeUpdatedAt());
        this.setAnswers(new ArrayList<>());
        return this;
    }

    /**
     * 回答情報をセットする(初期表示時用)
     * 
     * @param res
     * @param o
     * @return
     */
    public OogiriResponse setAnswerInfo(OogiriResponse res, Oogiri o) {
        OogiriAnswerResponse ansRes = new OogiriAnswerResponse();
        ansRes.setAnswerId(o.getAnswerId());
        ansRes.setAnswerUserId(o.getAnswerUserId());
        ansRes.setAnswerContent(o.getAnswerContent());
        ansRes.setAnswerCreatedAt(o.getAnswerCreatedAt());
        ansRes.setAnswerDeletedAt(o.getAnswerDeletedAt());
        res.getAnswers().add(ansRes);
        return res;
    }

    /**
     * エラーレスポンスを生成
     * 
     * @param errorCode
     * @param errorMessage
     * @return
     */
    public OogiriResponse setErrorResponse(int errorCode, String errorMessage) {
        OogiriResponse response = new OogiriResponse();
        return response;
    }

    /**
     * お題作成日時を取得します。
     * 
     * @return お題作成日時
     */
    public LocalDateTime getThemeCreatedAt() {
        return themeCreatedAt;
    }

    /**
     * お題作成日時を設定します。
     * 
     * @param themeCreatedAt お題作成日時
     */
    public void setThemeCreatedAt(LocalDateTime themeCreatedAt) {
        this.themeCreatedAt = themeCreatedAt;
    }

    /**
     * お題更新日時を取得します。
     * 
     * @return お題更新日時
     */
    public LocalDateTime getThemeUpdatedAt() {
        return themeUpdatedAt;
    }

    /**
     * お題更新日時を設定します。
     * 
     * @param themeUpdatedAt お題更新日時
     */
    public void setThemeUpdatedAt(LocalDateTime themeUpdatedAt) {
        this.themeUpdatedAt = themeUpdatedAt;
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

}
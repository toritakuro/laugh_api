package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.c4ccup.laugh.domain.Oogiri;

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
        this.setThemeInfo(this, oogiriList);
        this.setAnswerInfo(this, oogiriList);
    }

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
     * お題情報をセットする（詳細用）
     * 
     * @param oogiriRes
     * @param responses
     * @return
     */
    public OogiriResponse setThemeInfo(OogiriResponse oogiriRes, List<Oogiri> oogiriList) {
        oogiriRes.setThemeId(oogiriList.get(0).getThemeId());
        oogiriRes.setThemeUserId(oogiriList.get(0).getThemeUserId());
        oogiriRes.setThemeContent(oogiriList.get(0).getThemeContent());
        oogiriRes.setThemeCreatedAt(oogiriList.get(0).getThemeCreatedAt());
        return oogiriRes;
    }

    /**
     * 回答情報をセットする（詳細用）
     * 
     * @param oogiriRes
     * @param responses
     * @return
     */
    public OogiriResponse setAnswerInfo(OogiriResponse oogiriRes, List<Oogiri> oogiriList) {
        // 回答情報を詰めていく
        oogiriRes.setAnswers(new ArrayList<>());
        for (Oogiri oogiri : oogiriList) {
            OogiriAnswerResponse ansRes = new OogiriAnswerResponse();
            List<OogiriReactionResponse> oogiriReacResList = new ArrayList<>();
            ansRes.setAnswerId(oogiri.getAnswerId());
            ansRes.setAnswerUserId(oogiri.getAnswerUserId());
            ansRes.setAnswerContent(oogiri.getAnswerContent());
            ansRes.setAnswerCreatedAt(oogiri.getAnswerCreatedAt());
            ansRes.setAnswerDeletedAt(oogiri.getAnswerDeletedAt());
            // 回答に紐づくリアクションを取得
            oogiriReacResList = setReacInfo(oogiri, oogiriReacResList);
            ansRes.setReactions(oogiriReacResList);
            oogiriRes.getAnswers().add(ansRes);
        }
        return oogiriRes;
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
        List<Integer> ids = chgToInt(reactionIdStrList);
        List<Integer> userIds = chgToInt(reactionUserIdStrList);
        List<Integer> statuses = chgToInt(reactionStatusStrList);
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
     * 文字列配列をint型のリストに変換
     * 
     * @param strs
     * @return
     */
    private List<Integer> chgToInt(String[] strs) {
        List<Integer> intList = new ArrayList<>();
        for (String str : strs) {
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }
}
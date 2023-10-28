package com.c4ccup.laugh.controller.bean.res;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.c4ccup.laugh.domain.Oogiri;
import com.c4ccup.laugh.util.Util;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OogiriResources extends _Cmn {

    public OogiriResources() {

    }

    /**
     * 大喜利詳細用コンストラクタ
     *
     * @param oogiriList
     */
    public OogiriResources(List<Oogiri> oogiriList) {
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
    /** 回答数 */
    private int answerCount;

    // 回答情報
    /** 回答リスト */
    private List<OogiriAnswerResources> answers;

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
     * 回答数を取得します。
     *
     * @return 回答数
     */
    public int getAnswerCount() {
        return answerCount;
    }

    /**
     * 回答数を設定します。
     *
     * @param answerCount 回答数
     */
    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    /**
     * 回答リストを取得します。
     *
     * @return 回答リスト
     */
    public List<OogiriAnswerResources> getAnswers() {
        return answers;
    }

    /**
     * 回答リストを設定します。
     *
     * @param answers 回答リスト
     */
    public void setAnswers(List<OogiriAnswerResources> answers) {
        this.answers = answers;
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
            if (oogiri.getAnswerDeletedAt() != null) {
                continue;
            }
            OogiriAnswerResources ansRes = new OogiriAnswerResources();
            List<OogiriReactionResources> oogiriReacResList = new ArrayList<>();
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
    private List<OogiriReactionResources> setReacInfo(Oogiri res, List<OogiriReactionResources> oogiriReacResList) {
        // リアクション情報がない場合、終了
        if (res.getReactionIds() == null)
            return oogiriReacResList;
        // 文字列を分割しInteger型のリストに変換
        List<Integer> ids = Util.toIntList(res.getReactionIds());
        List<Integer> userIds = Util.toIntList(res.getReactionUserIds());
        List<Integer> statuses = Util.toIntList(res.getReactionStatuses());
        // リアクションリストに追加
        for (int i = 0; i < ids.size(); i++) {
            OogiriReactionResources oogiriReacRes = new OogiriReactionResources();
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
    public OogiriResources setThemeInfo(Oogiri o) {
        this.setThemeId(o.getThemeId());
        this.setThemeUserId(o.getThemeUserId());
        this.setThemeUserName(o.getThemeUserName());
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
    public OogiriResources setAnswerInfo(OogiriResources res, Oogiri o) {
        OogiriAnswerResources ansRes = new OogiriAnswerResources();
        ansRes.setAnswerId(o.getAnswerId());
        ansRes.setAnswerUserId(o.getAnswerUserId());
        ansRes.setAnswerUserName(o.getAnswerUserName());
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
    public OogiriResources setErrorResponse(int errorCode, String errorMessage) {
        OogiriResources response = new OogiriResources();
        return response;
    }

}

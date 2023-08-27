package com.c4ccup.laugh.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.OogiriAnswerResponse;
import com.c4ccup.laugh.controller.OogiriReactionResponse;
import com.c4ccup.laugh.domain.Oogiri;

/**
 * 大喜利 I/Fクラス
 *
 */
@Mapper
public interface OogiriRepository {
    /**
     * 大喜利お題を1件取得
     * 
     * @param themeId お題ID
     * @return Oogiri
     */
    public Oogiri getTheme(int themeId);

    /**
     * ユーザーIDでお題IDを取得
     * 
     * @param themeUserId お題ユーザーID
     * @return List<Integer>
     */
    public List<Integer> getThemeIdByUser(int themeUserId);

    /**
     * お題を更新順に取得
     * 
     * @param limit 件数
     * @return List<Oogiri>
     */
    public List<Oogiri> getLatestOogiriThemes(int limit);

    /**
     * 大喜利お題と紐づく回答をすべて取得
     * 
     * @return
     */
    public List<Oogiri> getAllOogiri(List<Integer> themeIds);

    /**
     * お題に対する回答を全件取得
     * 
     * @param themeId お題ID
     * @return List<Oogiri>
     */
    public List<Oogiri> getAllAnswers(int themeId);

    /**
     * お題に対する回答を3件取得
     * 
     * @param themeId お題ID
     * @return List<OogiriAnswerResponse>
     */
    public List<OogiriAnswerResponse> getThreeAnswers(int themeId, int limit);

    /**
     * お題を登録する
     * 
     * @param userId       ユーザーID
     * @param themeContent お題内容
     * @param now          現在時刻
     */
    public void regTheme(int userId, String themeContent, LocalDateTime now);

    /**
     * お題の更新日時を更新する
     * 
     * @param themeId お題ID
     * @param now     現在時刻
     */
    public void updTheme(int themeId, LocalDateTime now);

    /**
     * 回答を1件取得
     * 
     * @param answerId 回答ID
     * @return Oogiri
     */
    public Oogiri getAnswer(int answerId);

    /**
     * 回答を登録する
     * 
     * @param userId        ユーザーID
     * @param themeId       お題ID
     * @param answerContent 回答内容
     * @param now           現在時刻
     */
    public void regAnswer(int themeId, int userId, String answerContent, LocalDateTime now);

    /**
     * 回答を削除する
     * 
     * @param answerId 回答ID
     * @param now      現在時刻
     */
    public void delAnswer(int answerId, LocalDateTime now);

    /**
     * 回答に対するリアクションを全件取得
     * 
     * @param answerId
     * @return List<OogiriReactionResponse>
     */
    public List<OogiriReactionResponse> getAllReactions(int answerId);

    /**
     * リアクションを登録する
     * 
     * @param answerId       回答ID
     * @param userId         ユーザーID
     * @param reactionStatus リアクションステータス
     * @param now            現在時刻
     */
    public void regReaction(int answerId, int userId, int reactionStatus, LocalDateTime now);

    /**
     * リアクションを更新する
     * 
     * @param reactionId     リアクションID
     * @param reactionStatus リアクションステータス
     * @param now            現在時刻
     */
    public void editReaction(int reactionId, int reactionStatus, LocalDateTime now);

    /**
     * ユーザーが回答したお題のIDを全件取得
     * 
     * @param userId
     * @return
     */
    public List<Integer> getAnsweredThemeId(int userId);
}
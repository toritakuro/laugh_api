package com.c4ccup.laugh.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.OogiriAnswerResponse;
import com.c4ccup.laugh.controller.OogiriReactionResponse;
import com.c4ccup.laugh.domain.OogiriTheme;

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
     * @return OogiriTheme
     */
    public OogiriTheme getTheme(int themeId);

    /**
     * お題を更新順に取得
     * 
     * @param limit 件数
     * @return List<OogiriTheme>
     */
    public List<OogiriTheme> getLatestOogiriThemes(int limit);

    /**
     * お題に対する回答を全件取得
     * 
     * @param themeId お題ID
     * @return List<OogiriAnswerResponse>
     */
    public List<OogiriAnswerResponse> getAllAnswers(int themeId);

    /**
     * お題に対する回答を3件取得
     * 
     * @param themeId お題ID
     * @return List<OogiriAnswerResponse>
     */
    public List<OogiriAnswerResponse> getThreeAnswers(int themeId);

    /**
     * 回答に対するリアクションを全件取得
     * 
     * @param answerId
     * @return List<OogiriReactionResponse>
     */
    public List<OogiriReactionResponse> getAllReactions(int answerId);

    /**
     * お題を登録する
     * 
     * @param userId       ユーザーID
     * @param themeContent お題内容
     * @param now          現在時刻
     */
    public void regTheme(int userId, String themeContent, LocalDateTime now);

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
     * リアクションを登録する
     * 
     * @param answerId       回答ID
     * @param userId         ユーザーID
     * @param reactionStatus リアクションステータス
     * @param now            現在時刻
     */
    public void regReaction(int answerId, int userId, int reactionStatus, LocalDateTime now);
}
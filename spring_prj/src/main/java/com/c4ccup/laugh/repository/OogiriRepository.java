package com.c4ccup.laugh.repository;

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
     * @param お題ID
     * @return OogiriTheme
     */
    OogiriTheme getTheme(int themeId);

    /**
     * お題を更新順に取得
     * 
     * @param limit 件数
     * @return List<OogiriTheme>
     */
    List<OogiriTheme> getLatestOogiriThemes(int limit);

    /**
     * お題に対する回答を全件取得
     * 
     * @param themeId お題ID
     * @return List<OogiriAnswerResponse>
     */
    List<OogiriAnswerResponse> getAllAnswers(int themeId);

    /**
     * お題に対する回答を3件取得
     * 
     * @param themeId お題ID
     * @return List<OogiriAnswerResponse>
     */
    List<OogiriAnswerResponse> getThreeAnswers(int themeId);

    /**
     * 回答に対するリアクションを全件取得
     * 
     * @param answerId
     * @return List<OogiriReactionResponse>
     */
    List<OogiriReactionResponse> getAllReactions(int answerId);
}
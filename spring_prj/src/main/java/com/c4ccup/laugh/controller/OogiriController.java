package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.domain.OogiriAnswer;
import com.c4ccup.laugh.domain.OogiriTheme;
import com.c4ccup.laugh.repository.OogiriRepository;

/**
 * 大喜利Controllerクラス
 *
 */
@RequestMapping(value = "oogiri")
@RestController
public class OogiriController {

    private final OogiriRepository oogiriRepository;

    @Autowired
    public OogiriController(OogiriRepository oogiriRepository) {
        this.oogiriRepository = oogiriRepository;
    }

    /**
     * 一覧用大喜利データ取得
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OogiriResponse>> getOogiriThemes() {
        try {
            // レスポンスリスト
            List<OogiriResponse> responses = new ArrayList<>();
            // お題を50件取得
            List<OogiriTheme> oogiriThemes = oogiriRepository.getLatestOogiriThemes(50);

            // お題ごとにレスポンスを追加
            for (OogiriTheme theme : oogiriThemes) {
                List<OogiriAnswerResponse> answers = oogiriRepository.getThreeAnswers(theme.getThemeId());
                OogiriResponse response = OogiriResponse.themeAndAnswers(theme, answers);
                responses.add(response);
            }

            return ResponseEntity.ok(responses);
        } catch (Exception e) {
            // エラー時のレスポンス TODO:エラーレスポンスの中身(tori)
            List<OogiriResponse> errorResponse = new ArrayList<>();
            errorResponse.add(OogiriResponse.errorResponse(500, "Internal Server Error"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * 大喜利詳細データ取得
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public ResponseEntity<OogiriResponse> getOogiriAnswers(@RequestParam int themeId) {
        try {
            // お題取得
            OogiriTheme theme = oogiriRepository.getTheme(themeId);
            // お題に紐づく回答リストを取得
            List<OogiriAnswerResponse> answers = oogiriRepository.getAllAnswers(themeId);
            // 回答に紐づくリアクションリストをレスポンスに追加
            List<OogiriReactionResponse> reactions = new ArrayList<OogiriReactionResponse>();
            for (OogiriAnswerResponse answer : answers) {
                reactions = oogiriRepository.getAllReactions(answer.getAnswerId());
                answer.setReactions(reactions);
            }
            // 詳細用レスポンスを生成
            OogiriResponse response = OogiriResponse.oogiriDetails(theme, answers);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * お題登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> regTheme(@RequestBody OogiriRequest request) {

        int userId = request.getUserId();
        String themeContent = request.getThemeContent();
        LocalDateTime now = LocalDateTime.now();

        try {
            // お題登録
            oogiriRepository.regTheme(userId, themeContent, now);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * 回答登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer", method = RequestMethod.POST)
    public ResponseEntity<?> regAnswer(@RequestBody OogiriRequest request) {

        int themeId = request.getThemeId();
        int userId = request.getUserId();
        String answerContent = request.getAnswerContent();
        LocalDateTime now = LocalDateTime.now();

        try {
            // 回答登録
            oogiriRepository.regAnswer(themeId, userId, answerContent, now);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * 回答削除
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer/delete", method = RequestMethod.POST)
    public ResponseEntity<?> delAnswer(@RequestBody OogiriRequest request) {

        int userId = request.getUserId();
        int answerId = request.getAnswerId();
        LocalDateTime now = LocalDateTime.now();

        try {
            // リクエストのユーザーIDと回答ユーザーIDが一致しない場合、エラーを返す
            OogiriAnswer answer = oogiriRepository.getAnswer(answerId);
            if (answer.getAnswerUserId() != userId) {
                OogiriResponse errorResponse = OogiriResponse.errorResponse(400, "Bad Request");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
            // 回答削除処理
            oogiriRepository.delAnswer(answerId, now);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * リアクション登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/reaction", method = RequestMethod.POST)
    public ResponseEntity<?> regReaction(@RequestBody OogiriRequest request) {

        int answerId = request.getAnswerId();
        int userId = request.getUserId();
        int reactionStatus = request.getReactionStatus();
        LocalDateTime now = LocalDateTime.now();

        try {
            // リアクション登録
            oogiriRepository.regReaction(answerId, userId, reactionStatus, now);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * リアクション更新
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/reaction/edit", method = RequestMethod.POST)
    public ResponseEntity<?> editReaction(@RequestBody OogiriRequest request) {

        int answerId = request.getReactionId();
        int reactionStatus = request.getReactionStatus();
        LocalDateTime now = LocalDateTime.now();

        try {
            // リアクション更新
            oogiriRepository.editReaction(answerId, reactionStatus, now);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
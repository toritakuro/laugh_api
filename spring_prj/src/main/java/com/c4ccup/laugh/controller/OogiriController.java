package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.domain.OogiriTheme;
import com.c4ccup.laugh.repository.OogiriRepository;
import com.c4ccup.laugh.repository.UserRepository;

/**
 * 大喜利Controllerクラス
 *
 */
@RequestMapping(value = "oogiri")
@RestController
public class OogiriController {

    private final OogiriRepository oogiriRepository;
    private final UserRepository userRepository;

    @Autowired
    public OogiriController(OogiriRepository oogiriRepository, UserRepository userRepository) {
        this.oogiriRepository = oogiriRepository;
        this.userRepository = userRepository;
    }

    /**
     * 一覧用大喜利データ取得
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OogiriResponse>> getOogiriThemes() {
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
    }

    /**
     * 大喜利詳細データ取得
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public ResponseEntity<OogiriResponse> getOogiriAnswers(@RequestParam int themeId) {
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

        // お題登録
        oogiriRepository.regTheme(userId, themeContent, now);
        return ResponseEntity.ok().build();
    }

    /**
     * 回答登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<?> regAnswer(@RequestBody OogiriRequest request) {

        int themeId = request.getThemeId();
        int userId = request.getUserId();
        String answerContent = request.getAnswerContent();
        LocalDateTime now = LocalDateTime.now();

        // 回答登録
        oogiriRepository.regAnswer(themeId, userId, answerContent, now);

        // お題の更新日時を更新
        oogiriRepository.updTheme(themeId, now);
        return ResponseEntity.ok().build();
    }

    /**
     * 回答削除
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer/delete", method = RequestMethod.POST)
    public ResponseEntity<?> delAnswer(@RequestBody OogiriRequest request) {

        int answerId = request.getAnswerId();
        LocalDateTime now = LocalDateTime.now();

        // 回答削除処理
        oogiriRepository.delAnswer(answerId, now);
        return ResponseEntity.ok().build();
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

        // リアクション登録
        oogiriRepository.regReaction(answerId, userId, reactionStatus, now);
        return ResponseEntity.ok().build();
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

        // リアクション更新
        oogiriRepository.editReaction(answerId, reactionStatus, now);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<OogiriResponse> getOogiriByUser(@RequestParam String themeUserName, String answerUserName) {

        // ユーザーネームからユーザーIDを取得
        // IDで大喜利お題、回答それぞれのテーブルからデータを取得
        // レスポンスを生成する
        return ResponseEntity.ok().build();
    }
}
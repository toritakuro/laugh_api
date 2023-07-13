package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(path = "/init", method = RequestMethod.GET)
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
     * @param themeId お題ID
     * @return
     */
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public ResponseEntity<OogiriResponse> getOogiriAnswers(@RequestBody OogiriRequest request) {

        int themeId = request.getThemeId();
        try {
            OogiriTheme theme = oogiriRepository.getTheme(themeId);
            List<OogiriAnswerResponse> answers = oogiriRepository.getAllAnswers(themeId);
            List<OogiriReactionResponse> reactions = new ArrayList<OogiriReactionResponse>();
            for (OogiriAnswerResponse answer : answers) {
                reactions = oogiriRepository.getAllReactions(answer.getAnswerId());
                answer.setReactions(reactions);
            }
            OogiriResponse response = OogiriResponse.oogiriDetails(theme, answers);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            OogiriResponse errorResponse = OogiriResponse.errorResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
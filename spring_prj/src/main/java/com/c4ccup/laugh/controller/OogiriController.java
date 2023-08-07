package com.c4ccup.laugh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.domain.OogiriTheme;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.OogiriRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst;

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
        List<OogiriTheme> oogiriThemes = oogiriRepository.getLatestOogiriThemes(AppConst.oogiri_theme_disp_num);

        // レスポンスリストを生成
        responses = createInitResList(responses, oogiriThemes);

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

    /**
     * 大喜利検索
     * 
     * @param themeUserName
     * @param answerUserName
     * @return
     */
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<OogiriResponse>> getOogiriByUser(@RequestParam String themeUserName,
            String answerUserName) {
        // レスポンスリスト
        List<OogiriResponse> responses = new ArrayList<>();
        // お題リスト
        List<OogiriTheme> allThemes = new ArrayList<>();

        // お題作成者で検索
        // お題作成者用お題リスト
        List<OogiriTheme> themeResponses = new ArrayList<>();
        if (!themeUserName.isEmpty()) {
            // 検索お題ユーザーIDを取得
            List<Integer> themeUserIds = getUserIdsByName(themeUserName);
            // 取得したIDでお題リストを取得
            List<OogiriTheme> themes = new ArrayList<>();
            for (int userId : themeUserIds) {
                // ユーザーのIDでお題を取得
                themes = oogiriRepository.getThemeByUser(userId);
                // 取得したお題でレスポンスリストに追加
                themeResponses.addAll(themes);
            }
            // お題リストに追加
            allThemes.addAll(themeResponses);
        }

        // 回答者で検索
        // 回答者検索用お題リスト
        List<OogiriTheme> answerResponses = new ArrayList<>();
        if (!answerUserName.isEmpty()) {
            // 回答者ユーザーIDを取得
            List<Integer> answerUserIds = getUserIdsByName(answerUserName);
            // 取得したIDでお題リストを取得
            for (int userId : answerUserIds) {
                // ユーザーのIDでお題IDを取得
                List<Integer> themeIds = oogiriRepository.getThemeIds(userId);
                // お題IDでお題リストを取得
                answerResponses = getThemesByThemeId(answerResponses, themeIds);
            }
            allThemes.addAll(answerResponses);
        }

        // レスポンスを生成する
        responses = createInitResList(responses, allThemes);
        return ResponseEntity.ok(responses);
    }

    /**
     * 一覧用レスポンスの生成
     * 
     * @param responses
     * @param themes
     * @return
     */
    private List<OogiriResponse> createInitResList(List<OogiriResponse> responses, List<OogiriTheme> themes) {
        // お題ごとにレスポンスを追加
        Set<Integer> addedThemeIds = new HashSet<>();
        for (OogiriTheme theme : themes) {
            if (!addedThemeIds.contains(theme.getThemeId())) {
                List<OogiriAnswerResponse> answers = oogiriRepository.getThreeAnswers(theme.getThemeId(),
                        AppConst.oogiri_answer_disp_num);
                OogiriResponse response = OogiriResponse.themeAndAnswers(theme, answers);
                responses.add(response);
                addedThemeIds.add(theme.getThemeId()); // 重複を防ぐためにセットに追加
            }
        }
        return responses;
    }

    /**
     * ユーザー名でユーザーのIDリストを取得
     * 
     * @param userName
     * @return
     */
    private List<Integer> getUserIdsByName(String userName) {
        List<User> users = userRepository.findByName(userName);
        // ユーザーのIDリスト
        List<Integer> userIds = new ArrayList<>();
        for (User user : users) {
            userIds.add(user.getId());
        }
        return userIds;
    }

    /**
     * お題IDでお題リストを取得
     * 
     * @param themes
     * @param themeIds
     * @return
     */
    private List<OogiriTheme> getThemesByThemeId(List<OogiriTheme> themes, List<Integer> themeIds) {
        for (int themeId : themeIds) {
            themes.add(oogiriRepository.getTheme(themeId));
        }
        return themes;
    }
}
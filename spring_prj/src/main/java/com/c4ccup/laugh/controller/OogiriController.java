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
    private LocalDateTime now = LocalDateTime.now();

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

        int reactionId = request.getReactionId();
        int reactionStatus = request.getReactionStatus();

        // リアクション更新
        oogiriRepository.editReaction(reactionId, reactionStatus, now);
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
            String answerUserName, int page) {
        // レスポンスリスト
        List<OogiriResponse> responses = new ArrayList<>();
        // お題リスト
        List<OogiriTheme> themes = new ArrayList<>();

        // お題作成者で検索
        if (!themeUserName.isEmpty()) {
            // ユーザーIDを取得
            List<Integer> themeUserIds = getUserIdsByName(themeUserName);
            // お題リストを取得
            for (int userId : themeUserIds) {
                themes.addAll(oogiriRepository.getThemeByUser(userId));
            }
        }

        // 回答者で検索
        if (!answerUserName.isEmpty()) {
            // ユーザーIDを取得
            List<Integer> answerUserIds = getUserIdsByName(answerUserName);
            // お題リストを取得
            List<OogiriTheme> answerResponses = new ArrayList<>();
            for (int userId : answerUserIds) {
                themes.addAll(getThemesByThemeId(answerResponses, oogiriRepository.getThemeIds(userId)));
            }
        }

        // レスポンスを生成する
        responses = createInitResList(responses, themes);
        responses = resetResByPage(responses, page);
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
        Set<Integer> addedThemeIds = new HashSet<>();
        // お題ごとにレスポンスを追加
        for (OogiriTheme theme : themes) {
            // お題と紐づく回答3件をレスポンスに追加
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
     * @return themes お題リスト
     */
    private List<OogiriTheme> getThemesByThemeId(List<OogiriTheme> themes, List<Integer> themeIds) {
        for (int themeId : themeIds) {
            themes.add(oogiriRepository.getTheme(themeId));
        }
        return themes;
    }

    /**
     * ページ数によって要素をセットしなおす
     * 
     * @param responses
     * @param page
     * @return responses
     */
    private List<OogiriResponse> resetResByPage(List<OogiriResponse> responses, int page) {
        // レスポンスリストの要素数
        int totalElements = responses.size();
        // 抽出開始位置、終了位置
        int fromInd = (page - 1) * AppConst.oogiri_theme_disp_num;
        int toInd = fromInd + AppConst.oogiri_theme_disp_num;
        // 該当ページの最大数に要素数が満たない場合
        if (toInd > totalElements)
            toInd = totalElements;
        return responses.subList(fromInd, toInd);
    }
}
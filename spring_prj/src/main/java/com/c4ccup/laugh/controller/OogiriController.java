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

import com.c4ccup.laugh.controller.bean.res.OogiriResources;
import com.c4ccup.laugh.controller.bean.res._Messages;
import com.c4ccup.laugh.domain.Oogiri;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.OogiriRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst;
import com.c4ccup.laugh.util.MessageUtil;

/**
 * 大喜利Controllerクラス
 *
 */
@RequestMapping(value = "oogiri")
@RestController
public class OogiriController extends _CmnController {

    private final OogiriRepository oogiriRepository;
    private final UserRepository userRepository;
    private LocalDateTime now = LocalDateTime.now();

    @Autowired
    public OogiriController(OogiriRepository oogiriRepository, UserRepository userRepository) {
        this.oogiriRepository = oogiriRepository;
        this.userRepository = userRepository;
    }

    @Autowired
    MessageUtil msgUtil;

    /**
     * 一覧用大喜利データ取得
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OogiriResponse>> getOogiri(@RequestParam int page) {
        // お題を全件取得
        List<Oogiri> oogiriList = oogiriRepository.getAllOogiri();
        List<OogiriResponse> resList = new ArrayList<>();
        resList = createInitResList(resList, oogiriList);
        // お題の更新順に並び替え
        resList.sort((o1, o2) -> o2.getThemeUpdatedAt().compareTo(o1.getThemeUpdatedAt()));
        // ページング
        resList = resetResByPage(resList, page);
        return ResponseEntity.ok(resList);
    }

    /**
     * 大喜利詳細データ取得
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public ResponseEntity<OogiriResponse> getOogiriAnswers(@RequestParam int themeId) {
        // お題に紐づく回答リストを取得
        List<Oogiri> oogiriList = oogiriRepository.getAllAnswers(themeId);
        OogiriResponse oogiriRes = new OogiriResponse(oogiriList);
        return ResponseEntity.ok(oogiriRes);
    }

    /**
     * お題登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OogiriResources> regTheme(@RequestBody OogiriRequest request) {

        int userId = request.getUserId();
        String themeContent = request.getThemeContent();
        // お題登録
        oogiriRepository.regTheme(userId, themeContent, now);
        return ResponseEntity.ok(createMsg("お題", "登録"));
    }

    /**
     * 回答登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<OogiriResources> regAnswer(@RequestBody OogiriRequest request) {

        int themeId = request.getThemeId();
        int userId = request.getUserId();
        String answerContent = request.getAnswerContent();

        // 回答登録
        oogiriRepository.regAnswer(themeId, userId, answerContent, now);

        // お題の更新日時を更新
        oogiriRepository.updTheme(themeId, now);
        return ResponseEntity.ok(createMsg("回答", "登録"));
    }

    /**
     * 回答削除
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer/delete", method = RequestMethod.POST)
    public ResponseEntity<OogiriResources> delAnswer(@RequestBody OogiriRequest request) {

        int answerId = request.getAnswerId();

        // 回答削除処理
        oogiriRepository.delAnswer(answerId, now);
        return ResponseEntity.ok(createMsg("回答", "削除"));
    }

    /**
     * リアクション登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/reaction", method = RequestMethod.POST)
    public ResponseEntity<OogiriResources> regReaction(@RequestBody OogiriRequest request) {

        int answerId = request.getAnswerId();
        int userId = request.getUserId();
        int reactionStatus = request.getReactionStatus();

        // リアクション登録
        oogiriRepository.regReaction(answerId, userId, reactionStatus, now);
        return ResponseEntity.ok(createMsg("リアクション", "登録"));
    }

    /**
     * リアクション更新
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/reaction/edit", method = RequestMethod.POST)
    public ResponseEntity<OogiriResources> editReaction(@RequestBody OogiriRequest request) {

        int reactionId = request.getReactionId();
        int reactionStatus = request.getReactionStatus();

        // リアクション更新
        oogiriRepository.editReaction(reactionId, reactionStatus, now);
        return ResponseEntity.ok(createMsg("リアクション", "更新"));
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
        List<Oogiri> themes = new ArrayList<>();

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
            List<Oogiri> answerResponses = new ArrayList<>();
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
    private List<OogiriResponse> createInitResList(List<OogiriResponse> resList, List<Oogiri> oogiriList) {

        OogiriResponse res = null;
        int prevId = 0;
        for (Oogiri o : oogiriList) {
            int themeId = o.getThemeId();
            // お題IDが変わったら新しいOogiriResponseを作成
            if (prevId != themeId) {
                // 最初以外はここでレスポンスリストに追加する
                if (res != null)
                    resList.add(res);
                res = new OogiriResponse();
                res = res.setThemeInfo(o);
            }
            // 回答が3件セットされている場合スキップ
            if (res.getAnswers().size() >= AppConst.oogiri_answer_disp_num) {
                continue;
            }
            // 回答が削除済みでなければセット
            if (o.getAnswerDeletedAt() == null) {
                res = res.setAnswerInfo(res, o);
            }
            prevId = themeId;
        }
        // 最後の大喜利情報をここで追加
        resList.add(res);
        return resList;
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
    private List<Oogiri> getThemesByThemeId(List<Oogiri> themes, List<Integer> themeIds) {
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

    private OogiriResources createMsg(String str1, String str2) {
        OogiriResources oogiri = new OogiriResources();
        _Messages returnMsg = super.getReturnMsg(msgUtil.getMessage("s001", str1, str2));
        oogiri.setMessages(returnMsg);
        return oogiri;
    }
}
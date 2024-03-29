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

import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.Messages;
import com.c4ccup.laugh.controller.bean.res.OogiriResources;
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
    public ResponseEntity<ApiResource<List<OogiriResources>>> getOogiri() {
        // お題を全件取得
        List<Integer> themeIds = new ArrayList<>();
        List<Oogiri> oogiriList = oogiriRepository.getAllOogiri(themeIds);
        List<OogiriResources> resList = createInitResList(oogiriList);
        // お題の更新順に並び替え
        resList.sort((o1, o2) -> o2.getThemeUpdatedAt().compareTo(o1.getThemeUpdatedAt()));
        ApiResource<List<OogiriResources>> oogiri = new ApiResource<>(resList);
        return ResponseEntity.ok(oogiri);
    }

    /**
     * 大喜利詳細データ取得
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<OogiriResources>> getOogiriAnswers(@RequestParam int themeId) {
        // お題に紐づく回答リストを取得
        List<Oogiri> oogiriList = oogiriRepository.getAllAnswers(themeId);
        OogiriResources oogiriRes = new OogiriResources(oogiriList);
        ApiResource<OogiriResources> oogiri = new ApiResource<>(oogiriRes);
        return ResponseEntity.ok(oogiri);
    }

    /**
     * お題登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> regTheme(@RequestBody OogiriRequest request) {

        int userId = request.getUserId();
        String themeContent = request.getThemeContent();
        // お題登録
        oogiriRepository.regTheme(userId, themeContent, now);
        return ResponseEntity.ok(createMsg("s001", "お題", "登録"));
    }

    /**
     * お題削除
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/theme/delete", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> delTheme(@RequestBody OogiriRequest request) {

        int themeId = request.getThemeId();
        // お題削除処理
        oogiriRepository.delTheme(themeId);
        return ResponseEntity.ok(createMsg("s001", "お題", "削除"));
    }

    /**
     * 回答登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<ApiResource<Messages>> regAnswer(@RequestBody OogiriRequest request) {

        int themeId = request.getThemeId();
        int userId = request.getUserId();
        String answerContent = request.getAnswerContent();

        // 回答登録
        oogiriRepository.regAnswer(themeId, userId, answerContent, now);

        // お題の更新日時を更新
        oogiriRepository.updTheme(themeId, now);
        return ResponseEntity.ok(createMsg("s001", "回答", "登録"));
    }

    /**
     * 回答削除
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/answer/delete", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> delAnswer(@RequestBody OogiriRequest request) {

        int answerId = request.getAnswerId();

        // 回答削除処理
        oogiriRepository.delAnswer(answerId, now);
        return ResponseEntity.ok(createMsg("s001", "回答", "削除"));
    }

    /**
     * リアクション登録
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/reaction", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> regReaction(@RequestBody OogiriRequest request) {

        int answerId = request.getAnswerId();
        int userId = request.getUserId();
        int reactionStatus = request.getReactionStatus();

        // リアクション登録
        oogiriRepository.regReaction(answerId, userId, reactionStatus, now);
        return ResponseEntity.ok(createMsg("s001", "リアクション", "登録"));
    }

    /**
     * リアクション更新
     * 
     * @param request
     * @return
     */
    @RequestMapping(path = "/reaction/edit", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> editReaction(@RequestBody OogiriRequest request) {

        int reactionId = request.getReactionId();
        int reactionStatus = request.getReactionStatus();

        // リアクション更新
        oogiriRepository.editReaction(reactionId, reactionStatus, now);
        return ResponseEntity.ok(createMsg("s001", "リアクション", "更新"));
    }

    /**
     * 大喜利検索
     * 
     * @param themeUserName
     * @param answerUserName
     * @return
     */
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getOogiriByUser(@RequestParam String themeUserName, String answerUserName) {
        // お題IDリスト
        List<Integer> themeIds = new ArrayList<>();

        // お題作成者で検索
        if (!themeUserName.isEmpty()) {
            // ユーザーIDを取得
            List<Integer> themeUserIds = getUserIdsByName(themeUserName);
            // ユーザーが作成したお題のIDをリストに追加
            for (int userId : themeUserIds) {
                themeIds.addAll(oogiriRepository.getThemeIdByUser(userId));
            }
        }

        // 回答者で検索
        if (!answerUserName.isEmpty()) {
            // ユーザーIDを取得
            List<Integer> answerUserIds = getUserIdsByName(answerUserName);
            // お題リストを取得
            for (int userId : answerUserIds) {
                themeIds.addAll(oogiriRepository.getAnsweredThemeId(userId));
            }
        }

        // ユーザーの投稿がなかった場合
        if (themeIds.isEmpty()) {
            return ResponseEntity.ok(createMsg("s002", "検索結果", "0件"));
        }

        // レスポンスを生成する
        List<Oogiri> oogiriList = oogiriRepository.getAllOogiri(themeIds);
        List<OogiriResources> resList = createInitResList(oogiriList);
        ApiResource<List<OogiriResources>> oogiri = new ApiResource<>(resList);
        return ResponseEntity.ok(oogiri);
    }

    /**
     * 一覧用レスポンスの生成
     * 
     * @param responses
     * @param themes
     * @return
     */
    private List<OogiriResources> createInitResList(List<Oogiri> oogiriList) {

        List<OogiriResources> resList = new ArrayList<>();
        OogiriResources res = null;
        int prevId = 0; // お題ID判定用
        int answerCount = 0; // 回答数カウント用
        for (Oogiri o : oogiriList) {
            int themeId = o.getThemeId();
            // お題IDが変わったら新しいOogiriResourcesを作成
            if (prevId != themeId) {
                // 最後以外はここでレスポンスリストに追加する
                if (res != null) {
                    res.setAnswerCount(answerCount);
                    resList.add(res);
                }
                res = new OogiriResources();
                res = res.setThemeInfo(o);
                answerCount = 0;
            }
            // 回答が3件セットされている場合スキップ
            if (res.getAnswers().size() >= AppConst.oogiri_answer_disp_num) {
                if (o.getAnswerDeletedAt() == null)
                    answerCount++;
                continue;
            }
            // 回答が削除済みでなければセット
            if (o.getAnswerDeletedAt() == null && o.getAnswerId() != 0) {
                answerCount++;
                res = res.setAnswerInfo(res, o);
            }
            prevId = themeId;
        }
        // 最後の大喜利情報をここで追加
        res.setAnswerCount(answerCount);
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
     * メッセージを生成する
     * 
     * @param code
     * @param str1
     * @param str2
     * @return
     */
    private ApiResource<Messages> createMsg(String code, String str1, String str2) {
        Messages returnMsg = super.getReturnMsg(msgUtil.getMessage(code, str1, str2));
        ApiResource<Messages> oogiri = new ApiResource<>(returnMsg);
        return oogiri;
    }
}
package com.c4ccup.laugh.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.ContentResources;
import com.c4ccup.laugh.controller.bean.res.LaughResource;
import com.c4ccup.laugh.controller.bean.res.Messages;
import com.c4ccup.laugh.controller.bean.res.UserResource;
import com.c4ccup.laugh.domain.Content;
import com.c4ccup.laugh.domain.Laugh;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.MyPageRepository;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.AwsS3Util;
import com.c4ccup.laugh.util.ByteArrayMultipartFile;
import com.c4ccup.laugh.util.EnumConst.MatchStatus;
import com.c4ccup.laugh.util.MessageUtil;

/**
 * マイページ Controllerクラス
 */
@RequestMapping(value = "mypage")
@RestController
public class MyPageController extends _CmnController {

    @Autowired
    MyPageRepository mypageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AwsS3Util awsS3Util;
    @Autowired
    MessageUtil msgUtil;

    /**
     * ログイン情報を取得する。
     * @param bean
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApiResource<UserResource>> mypage(MyPageBean bean) {
        User user ;
        if (bean.getUserType() == UserEnum.COMEDIAN.getId())  {
            user = userRepository.getComedian(bean.getUserId());
        } else {
            user = userRepository.getComposer(bean.getUserId());
        }
        return ResponseEntity.ok(new ApiResource<>(new UserResource(user)));
    }

    /**
     * laughの一覧を取得する。
     * 自分が送ったlaughと送られたlaughを取得する。
     * @param bean
     * @return
     */
    @RequestMapping(value ="laugh" , method = RequestMethod.GET)
    public ResponseEntity<ApiResource<List<LaughResource>>> laughList(MyPageBean bean) {
        List<Laugh> LaughList = mypageRepository.selectLaugh(bean.getUserId());
        List<LaughResource> result = new ArrayList<>();

        // Loughの一覧設定
        for (Laugh l : LaughList) {
            LaughResource r = new LaughResource();
            int[] activeTerm = null;

            r.setId(l.getId());
            r.setStatus(l.getStatus());
            r.setStatusStr(MatchStatus.getValByKey(l.getStatus()));

            if (l.getReceiveUserId() == bean.getUserId()) {
                r.setName(l.getUserNameSend());
                r.setTargetUserId(l.getUserIdSend());
                r.setMySendLough(false);
                activeTerm= getActiveTerm(l.getUerDebutAtSend());
            }
            if (l.getSendUserId() == bean.getUserId()) {
                r.setName(l.getUserNameReceive());
                r.setTargetUserId(l.getUserIdReceive());
                r.setMySendLough(true);
                activeTerm = getActiveTerm(l.getUserDebutAtReceive());
            }
            r.setActiveTermYear(activeTerm[0]);
            r.setActiveTermMonth(activeTerm[1]);

            result.add(r);
        }

        return ResponseEntity.ok(new ApiResource<>(result));
    }

    /**
     * 活動歴を取得する
     * @param debutAt
     * @return int[] 0:年、1:月
     */
    private int[] getActiveTerm(LocalDate debutAt) {
        int month = (int) ChronoUnit.MONTHS.between(debutAt.withDayOfMonth(1), LocalDate.now().withDayOfMonth(1)) + 1;
        return new int[]{(month / 12),(month % 12)};
    }

    /**
     * コンテンツをS3に登録する
     * @param
     */
    @RequestMapping(value ="uploadContent" , method = RequestMethod.POST)
    private ResponseEntity<ApiResource<Messages>> uploadContent(@RequestBody MyPageBean bean) {

//      //サムネイルをS3に登録
//      if(bean.getTopImg() != null && !bean.getTopImg().isEmpty()) {
//          String DataUriSchema = bean.getTopImg().split(",")[0];  // Data URIスキーマ
//          String mimeType = DataUriSchema.split(";")[0].split(":")[1];  // MIME TYPE
//          String base64 = bean.getTopImg().split(",")[1];  // base64
//
//          byte[] decodedBytes = Base64.getDecoder().decode(base64);
//        //byte[] decodedBytes = Base64.getDecoder().decode(bean.getTopImg());
//          MultipartFile multipartFile = new ByteArrayMultipartFile(decodedBytes, "file", bean.getTitle(), mimeType);
//
//          String uploadedFileName = awsS3Util.uploadFile(bean.getUserId(), multipartFile);
//
//          String s3Url = "https://c4claugh.s3.ap-northeast-1.amazonaws.com/" + bean.getUserId() + "/" + uploadedFileName;
//          bean.setTopImgPath(s3Url);
//
//      }



    //コンテンツをS3に登録
    if(bean.getContent() != null && !bean.getContent().isEmpty()) {
        String DataUriSchema = bean.getContent().split(",")[0];  // Data URIスキーマ
        String base64 = bean.getContent().split(",")[1];  // base64

        byte[] decodedBytes = Base64.getDecoder().decode(base64);
      //byte[] decodedBytes = Base64.getDecoder().decode(bean.getTopImg());
        MultipartFile multipartFile = new ByteArrayMultipartFile(decodedBytes, "file", bean.getTitle(), null);

        String uploadedFileName = awsS3Util.uploadFile(bean.getUserId(), multipartFile);

        String s3Url = "https://c4claugh.s3.ap-northeast-1.amazonaws.com/" + bean.getUserId() + "/" + uploadedFileName;
        bean.setContentPath(s3Url);
    }

    // awsS3Util使う際はタイトルに拡張子が必須だが、DBに登録する際は不要と思われるので、拡張子の部分を省いて登録する
    StringBuilder title = new StringBuilder();
    for (int i = 0; i < bean.getTitle().split("\\.").length - 1; i++) {
        title.append(bean.getTitle().split("\\.")[i]);
        if (i < bean.getTitle().split("\\.").length - 2) {
            title.append(".");
        }
    }
    bean.setTitle(title.toString());

    mypageRepository.uploadContent(bean);

        return ResponseEntity.ok(new ApiResource<>(super.getReturnMsg(msgUtil.getMessage("s001", "コンテンツ", "アップロード"))));
    }

    /**
     * コンテンツを取得する
     * @param
     * @return
     */
    @RequestMapping(value ="getFile" , method = RequestMethod.GET)
    private ResponseEntity<ApiResource<List<ContentResources>>> getFile(@RequestParam int userId) {
        List<Content> contentList = mypageRepository.selectContent(userId);
        List<ContentResources> result = new ArrayList<>();

        for (Content content : contentList) {
            ContentResources r = new ContentResources();

            r.setId(content.getId());
            r.setUserId(content.getUserId());
            r.setUserId(content.getUserId());
            r.setTitle(content.getTitle().split("\\.")[0]);
            r.setDetail(content.getDetail());
            r.setFileType(content.getFileType());
            r.setContentPath(content.getContentPath());
            r.setCreateAt(content.getCreateAt());
            r.setUpdateAt(content.getUpdateAt());

            result.add(r);
        }

        return ResponseEntity.ok(new ApiResource<>(result));
    }

    /**
     * コンテンツを編集する
     * @param
     */
    @RequestMapping(value ="editFile" , method = RequestMethod.POST)
    private ResponseEntity<ApiResource<Messages>> editFile(@RequestBody MyPageBean bean) {
        bean.setUpdateAt(LocalDateTime.now());
        mypageRepository.editContent(bean);

        return ResponseEntity.ok(new ApiResource<>(super.getReturnMsg(msgUtil.getMessage("s001", "コンテンツ", "編集"))));
    }

    /**
     * コンテンツを削除する
     * @param
     */
    @RequestMapping(value ="deleteFile" , method = RequestMethod.POST)
    private ResponseEntity<ApiResource<Messages>> deleteFile(@RequestBody MyPageBean bean) {
        mypageRepository.deleteContent(bean.getId());

        return ResponseEntity.ok(new ApiResource<>(super.getReturnMsg(msgUtil.getMessage("s001", "コンテンツ", "削除"))));
    }



}



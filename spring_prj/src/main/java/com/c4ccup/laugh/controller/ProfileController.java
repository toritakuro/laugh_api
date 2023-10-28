package com.c4ccup.laugh.controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.c4ccup.laugh.controller.bean.req.ProfileBean;
import com.c4ccup.laugh.controller.bean.res.ApiResource;
import com.c4ccup.laugh.controller.bean.res.Messages;
import com.c4ccup.laugh.controller.bean.res.ProfileResource;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.UserRepository;
import com.c4ccup.laugh.util.AppConst.DateFormatEnum;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.AwsS3Util;
import com.c4ccup.laugh.util.AwsSesUtil;
import com.c4ccup.laugh.util.ByteArrayMultipartFile;
import com.c4ccup.laugh.util.MessageUtil;
import com.c4ccup.laugh.util.PropBean;
import com.c4ccup.laugh.util.Util;
/**
 * CRUDを操作するProfileクラス
 *
 */
@RequestMapping(value = "profile")
@RestController
public class ProfileController extends _CmnController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AwsSesUtil awsSesUtil;
    @Autowired
    private AwsS3Util s3Util;
    @Autowired
    MessageUtil msgUtil;

    /**
     * メールを送信するメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/init", method = RequestMethod.POST)
    public void init(@RequestBody PropBean propBean) {
        String userMailAddress = propBean.getEmail();
        String Title = "Laughの登録";
        String Text = "<p>以下のURLから登録をお願いします。</p><br>"
                     + "http://localhost:3000/profile/register/"
                     + propBean.getEmail().replace(".", "+");
        awsSesUtil.send(userMailAddress, Title, Text);
    }

    /**
     * 新規登録するメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@RequestBody ProfileBean bean) {

//      //debutDtをセット(作家のみ)
//      if(bean.getUserType() == UserEnum.COMEDIAN.getId()) {
//          LocalDate debutDt = LocalDate.of(bean.getDebutYear(), bean.getDebutMonth(), 1);
//          bean.setDebutDt(debutDt);
//      }
      bean.setDebutDt(LocalDate.now());

        // ユーザーをuserテーブルに登録する。
        userRepository.register(bean);
        // 採番されたidを取得しregisterUserIdに入れる
        int registerUserId = bean.getId();

        // 登録したユーザーのuserIdをセットしておく
        bean.setUserId(registerUserId);

        //サムネイルをS3に登録
        String[] awsUploadFileInfo = Util.toAwsUploadFileInfo(bean.getProfileImgPath());

        byte[] decodedBytes = Base64.getDecoder().decode(awsUploadFileInfo[0]);
        MultipartFile multipartFile = new ByteArrayMultipartFile(decodedBytes, "file", "dummy" + awsUploadFileInfo[2], awsUploadFileInfo[1]);
        String fileName = s3Util.uploadFile(registerUserId, multipartFile);
        String url = AwsS3Util.S3URL + registerUserId +"/" + fileName;
        userRepository.updateImg(registerUserId, url);

        // 作家プロフィールの登録
        if(bean.getUserType() == UserEnum.COMPOSER.getId()) {
            userRepository.registerComposer(bean);
        }
        // 芸人プロフィールの登録
        if(bean.getUserType() == UserEnum.COMEDIAN.getId()) {
            userRepository.registerComedian(bean);
        }

        // 得意分野の登録(作家・芸人どちらも)
        if (bean.getComedyStyleIdList() != null) {
            for(int comedyStyleId: bean.getComedyStyleIdList()) {
                bean.setComedyStyleId(comedyStyleId);
                userRepository.registerOwnComedyStyle(bean);
            }
        }

        // 特殊スキルの登録(作家のみ)
        if (bean.getUserType() == UserEnum.COMPOSER.getId()) {
            List<ProfileBean> userBeanList = new ArrayList<>();

            if(bean.getSpecialSkillIdList() != null) {
                for(int specialSkillId: bean.getSpecialSkillIdList()) {
                    ProfileBean user = new ProfileBean();
                    user.setUserId(registerUserId);
                    user.setSpecialSkillId(specialSkillId);
                    userBeanList.add(user);
                }
            }

            // 「その他」で自由入力された内容は、specialSkillId = nullで登録する
            if(!bean.getAnotherSkill().isEmpty()) {
                ProfileBean user = new ProfileBean();
                user.setUserId(registerUserId);
                user.setAnotherSkill(bean.getAnotherSkill());
                userBeanList.add(user);
            }

            if(userBeanList != null) {
                userRepository.registerOwnSpecialSkill(userBeanList);
            }
        }
    }

    /**
     * 編集画面を返すメソッド
     * @param userBean
     * @return
     */
    @RequestMapping(path = "/editInit", method = RequestMethod.GET)
    public ResponseEntity<ApiResource<ProfileResource>> editInit(@RequestParam int loginUserType, @RequestParam int loginUserId) {
//        int loginUserType = bean.getUserType();
//        int loginUserId = bean.getUserId();
        User user = new User();

        // 作家を取得
        if (loginUserType == UserEnum.COMEDIAN.getId()) {
            user = userRepository.getComedian(loginUserId);
        }
        // 芸人を取得
        if (loginUserType == UserEnum.COMPOSER.getId()) {
            user = userRepository.getComposer(loginUserId);
        }

        ProfileResource profile = new ProfileResource(user);

        if(user.getComedyStyleIds() != null) {
            // int型に変換
            List<Integer> comedyIdList = Util.toIntList(user.getComedyStyleIds());
            profile.setComedyStyleIdList(comedyIdList);
        }

        // 特殊スキルを取得(作家用)
        if (profile.getUserType() == UserEnum.COMPOSER.getId() && user.getSpecialSkillIds() != null) {
            // int型に変換
            List<Integer> specialSkillIdList = Util.toIntList(user.getComedyStyleIds());
            profile.setSpecialSkillIdList(specialSkillIdList);
        }

        return ResponseEntity.ok(new ApiResource<>(profile));
    }

    /**
     * 更新するメソッド
     * @param ProfileBean
     */
    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> edit(@Validated @RequestBody ProfileBean bean) {
        int loginUserType = bean.getUserType();
        int loginUserId = bean.getId();
        bean.setUserId(loginUserId);

        //debutDtをセット
        bean.setDebutDt(Util.toLocalDate(bean.getDebutDtStr() + "-01", DateFormatEnum.HYPHEN_YMD));

        // ユーザーをuserテーブルに登録する。
        userRepository.updateProfile(bean);

        // 作家プロフィールの更新
        if(loginUserType == UserEnum.COMPOSER.getId()) {
            userRepository.updateComposer(bean);
        }

        // 芸人プロフィールの更新
        if(loginUserType == UserEnum.COMEDIAN.getId()) {
            userRepository.updateComedian(bean);
        }

        // 得意分野の更新(作家・芸人どちらも)
        userRepository.deleteOwnComedyStyle(loginUserId);
        if (bean.getComedyStyleIdList() != null) {
            for(int comedyStyleId: bean.getComedyStyleIdList()) {
                bean.setComedyStyleId(comedyStyleId);
                userRepository.registerOwnComedyStyle(bean);
            }
        }

        // 特殊スキルの更新(作家のみ)
        userRepository.deleteOwnSpecialSkill(loginUserId);
        if (loginUserType == UserEnum.COMPOSER.getId()) {
            List<ProfileBean> profileBeanList = new ArrayList<>();
            for(int specialSkillId: bean.getSpecialSkillIdList()) {
                ProfileBean profile = new ProfileBean();
                profile.setUserId(loginUserId);
                profile.setSpecialSkillId(specialSkillId);
                profileBeanList.add(profile);
            }
            // 「その他」で自由入力された内容は、specialSkillId = nullで登録する
            if(!bean.getAnotherSkill().isEmpty()) {
                ProfileBean profile = new ProfileBean();
                profile.setUserId(loginUserId);
                profile.setAnotherSkill(bean.getAnotherSkill());
                profileBeanList.add(profile);
            }
            userRepository.registerOwnSpecialSkill(profileBeanList);
        }

        return ResponseEntity.ok(new ApiResource<>(super.getReturnMsg(msgUtil.getMessage("s001", "プロフィール", "更新"))));
    }

    /**
     * プロフ画面を更新するメソッド
     * @param ProfileBean
     */
    @RequestMapping(path = "/editImg", method = RequestMethod.POST)
    public ResponseEntity<ApiResource<Messages>> editImg(@RequestBody ProfileBean bean) {

        int userId = bean.getId();

        //サムネイルをS3に登録
        String[] awsUploadFileInfo = Util.toAwsUploadFileInfo(bean.getProfileImgPath());

        byte[] decodedBytes = Base64.getDecoder().decode(awsUploadFileInfo[0]);
        MultipartFile multipartFile = new ByteArrayMultipartFile(decodedBytes, "file", "dummy" + awsUploadFileInfo[2], awsUploadFileInfo[1]);
        String fileName = s3Util.uploadFile(userId, multipartFile);
        String url = AwsS3Util.S3URL + userId +"/" + fileName;
        userRepository.updateImg(userId, url);

        return ResponseEntity.ok(new ApiResource<>(super.getReturnMsg(msgUtil.getMessage("s001", "プロフィール画像", "更新"))));
    }

}
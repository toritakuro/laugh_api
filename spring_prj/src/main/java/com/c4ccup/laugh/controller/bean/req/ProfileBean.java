package com.c4ccup.laugh.controller.bean.req;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import com.c4ccup.laugh.util.AppConst.FeeEnum;
import com.c4ccup.laugh.util.AppConst.UserEnum;
import com.c4ccup.laugh.util.PasswordUtil;

/**
 * マイページBean
 */
public class ProfileBean {

    // userテーブル用
    /** ID */
    private int id;
    /** ユーザアドレス */
    private String userAddress;
    /** 活動名 */
    @NotEmpty
    private String userName;
    /** 活動名(かな) */
    private String userNameKana;
    /** 活動種別 */
    private int userType;
    /** パスワード */
    private String password;
    /** 活動開始年 */
    private int debutYear;
    /** 活動開始月 */
    private int debutMonth;
    /** 活動開始年月 */
    private LocalDate debutDt;
    /** 活動開始年月(yyyy-MM) */
    private String debutDtStr;
    /** 性別 */
    private int gender;
    /** 事務所ID */
    private int officeId;
    /** 活動場所ID */
    private int areaId;
    /** 自己紹介文 */
    private String selfIntroduction;
    /** プロフィール画像 */
    private byte[] profileImgPath;
    /** 退会フラグ */
    private int deleteFlg;
    /** ログイン日時 */
    private LocalDateTime loginAt;
    /** 作成日時 */
    private LocalDateTime createAt;
    /** 更新日時 */
    private LocalDateTime updateAt;

    // userテーブル以外用
    /** ユーザID */
    private int userId;

    // comedian_profileテーブル用
    /** 活動人数 */
    private int memberNum;

    // composer_profileテーブル用
    /** 料金体系 */
    private int feeType;
    /** 料金 */
    private int fee;

    // own_comedy_styleテーブル用
    /** 得意分野 */
    private int comedyStyleId;
    /** 得意分野一覧 */
    @NotEmpty
    private List<Integer> comedyStyleIdList;

    // own_comedy_styleテーブル用
    /** 特殊スキル */
    private Integer specialSkillId;
    /** 特殊スキル(その他) */
    private String anotherSkill;
    /** 特殊スキル一覧 */
    private List<Integer> specialSkillIdList;



    /**
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id セットする id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }
    /**
     * @param userAddress セットする userAddress
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    /**
     * @return userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName セットする userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return userNameKana
     */
    public String getUserNameKana() {
        return userNameKana;
    }
    /**
     * @param userNameKana セットする userNameKana
     */
    public void setUserNameKana(String userNameKana) {
        this.userNameKana = userNameKana;
    }
    /**
     * @return userType
     */
    public int getUserType() {
        return userType;
    }
    /**
     * @param userType セットする userType
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = PasswordUtil.hashPassword(password);
    }
    /**
     * @return debutYear
     */
    public int getDebutYear() {
        return debutYear;
    }
    /**
     * @param debutYear セットする debutYear
     */
    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }
    /**
     * @return debutMonth
     */
    public int getDebutMonth() {
        return debutMonth;
    }
    /**
     * @param debutMonth セットする debutMonth
     */
    public void setDebutMonth(int debutMonth) {
        this.debutMonth = debutMonth;
    }
    /**
     * @return debutDt
     */
    public LocalDate getDebutDt() {
        return debutDt;
    }
    /**
     * @param debutDt セットする debutDt
     */
    public void setDebutDt(LocalDate debutDt) {
        this.debutDt = debutDt;
    }
    /**
     * 活動開始年月(yyyy-MM)を取得します。
     * @return 活動開始年月(yyyy-MM)
     */
    public String getDebutDtStr() {
        return debutDtStr;
    }
    /**
     * 活動開始年月(yyyy-MM)を設定します。
     * @param debutDtStr 活動開始年月(yyyy-MM)
     */
    public void setDebutDtStr(String debutDtStr) {
        this.debutDtStr = debutDtStr;
    }
    /**
     * @return gender
     */
    public int getGender() {
        return gender;
    }
    /**
     * @param gender セットする gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }
    /**
     * @return officeId
     */
    public int getOfficeId() {
        return officeId;
    }
    /**
     * @param officeId セットする officeId
     */
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
    /**
     * @return areaId
     */
    public int getAreaId() {
        return areaId;
    }
    /**
     * @param areaId セットする areaId
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    /**
     * @return selfIntroduction
     */
    public String getSelfIntroduction() {
        return selfIntroduction;
    }
    /**
     * @param selfIntroduction セットする selfIntroduction
     */
    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }
    /**
     * @return profileImgPath
     */
    public String getprofileImgPath() {
        if(profileImgPath != null) {
            return Base64.getEncoder().encodeToString(profileImgPath);
        }
        return null;
    }
    /**
     * @param profileImgPath セットする profileImgPath
     */
    public void setprofileImgPath(String profileImgPath) {
        if(profileImgPath != null) {
            this.profileImgPath = Base64.getDecoder().decode(profileImgPath);
            return;
        }
        this.profileImgPath = null;
    }
    /**
     * @return deleteFlg
     */
    public int getDeleteFlg() {
        return deleteFlg;
    }
    /**
     * @param deleteFlg セットする deleteFlg
     */
    public void setDeleteFlg(int deleteFlg) {
        this.deleteFlg = deleteFlg;
    }
    /**
     * @return loginAt
     */
    public LocalDateTime getLoginAt() {
        return loginAt;
    }
    /**
     * @param loginAt セットする loginAt
     */
    public void setLoginAt(LocalDateTime loginAt) {
        this.loginAt = loginAt;
    }
    /**
     * @return createAt
     */
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    /**
     * @param createAt セットする createAt
     */
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    /**
     * @return updateAt
     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    /**
     * @param updateAt セットする updateAt
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * @return memberNum
     */
    public int getMemberNum() {
        return memberNum;
    }
    /**
     * @param memberNum セットする memberNum
     */
    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }
    /**
     * @return feeType
     */
    public int getFeeType() {
        return feeType;
    }
    /**
     * @param feeType セットする feeType
     */
    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }
    /**
     * @return fee
     */
    public int getFee() {
        return fee;
    }
    /**
     * @param fee セットする fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }
    /**
     * @return comedyStyleId
     */
    public int getComedyStyleId() {
        return comedyStyleId;
    }
    /**
     * @param comedyStyleId セットする comedyStyleId
     */
    public void setComedyStyleId(int comedyStyleId) {
        this.comedyStyleId = comedyStyleId;
    }
    /**
     * @return comedyStyleIdList
     */
    public List<Integer> getComedyStyleIdList() {
        return comedyStyleIdList;
    }
    /**
     * @param comedyStyleIdList セットする comedyStyleIdList
     */
    public void setComedyStyleIdList(List<Integer> comedyStyleIdList) {
        this.comedyStyleIdList = comedyStyleIdList;
    }
    /**
     * @return specialSkillId
     */
    public Integer getSpecialSkillId() {
        return specialSkillId;
    }
    /**
     * @param specialSkillId セットする specialSkillId
     */
    public void setSpecialSkillId(Integer specialSkillId) {
        this.specialSkillId = specialSkillId;
    }
    /**
     * @return anotherSkill
     */
    public String getAnotherSkill() {
        return anotherSkill;
    }
    /**
     * @param anotherSkill セットする anotherSkill
     */
    public void setAnotherSkill(String anotherSkill) {
        this.anotherSkill = anotherSkill;
    }
    /**
     * @return specialSkillIdList
     */
    public List<Integer> getSpecialSkillIdList() {
        return specialSkillIdList;
    }
    /**
     * @param specialSkillIdList セットする specialSkillIdList
     */
    public void setSpecialSkillIdList(List<Integer> specialSkillIdList) {
        this.specialSkillIdList = specialSkillIdList;
    }

    // 相関バリデーション
    /**
     * 作家の場合、金額必須
     * @return
     */
    @AssertTrue(message = "金額は必須です。")
    public boolean isMustFee() {
        if (this.userType == UserEnum.COMPOSER.getId()) {
            // 金額体系が選択されていること
            if (!(this.feeType == FeeEnum.TIME.getId() || this.feeType == FeeEnum.PRODUCT.getId())) {
                return false;
            }
            // 金額が入力されていること
            return this.fee >= 0;
        }
        return true;
    }


}

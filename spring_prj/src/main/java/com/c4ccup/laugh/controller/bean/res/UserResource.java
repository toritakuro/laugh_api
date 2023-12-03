package com.c4ccup.laugh.controller.bean.res;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.util.AppConst.DateFormatEnum;
import com.c4ccup.laugh.util.Util;

/**
 * UserResourceクラス
 */
public class UserResource {

    /** ID */
    private int id;
    /** ユーザ名 */
    private String userName;
    /** ユーザ名(かな) */
    private String userNameKana;
    /** 検索用ユーザ名 */
    private String searchUserName;
    /** 活動種別 */
    private int userType;
    /** 活動開始年月 */
    private LocalDate debutDt;
    /** 活動開始年月(YYYY-MM) */
    private String debutDtStr;
    /** 活動年月 */
    private String activityDt;
    /** 活動年数 */
    private int activityNum;
    /** 性別 */
    private int gender;
    /** 事務所ID */
    private int officeId;
    /** オフィス名 */
    private String officeName;
    /** 活動場所ID */
    private int areaId;
    /** 活動地域名 */
    private String areaName;
    /** 自己紹介文 */
    private String selfIntroduction;
    /** プロフィール画像 */
    private String profileImgPath;
    /** ログイン日時 */
    private LocalDateTime loginAt;
    /** ログイン日時 並び替え用 */
    private Integer loginAtInt;
    /** 更新日時 */
    private LocalDateTime updateAt;
    /** 更新日時 並び替え用 */
    private Integer updateAtInt;
    /** 活動人数 */
    private int memberNum;
    /** 料金体系 */
    private int feeType;
    /** 料金 */
    private int fee;
    /** 得意分野・芸風Idリスト */
    private List<Integer> comedyStyleIdList = new ArrayList<>();
    /** 得意分野・芸風リスト */
    private List<String> comedyStyleNameList = new ArrayList<>();;
    /** 特殊スキル一覧 */
    private List<Integer> specialSkillIdList = new ArrayList<>();
    /** 特殊スキル名リスト */
    private List<String> specialSkillNameList = new ArrayList<>();
    /** その他特殊スキル */
    private String anotherSkill;

    /** idトークン */
    private String idToken;
    /** リフレッシュトークン */
    private String refreshToken;
    /** マッチステータス */
    private Integer matchStatus;


    public UserResource() {

    }

    public UserResource(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userNameKana = user.getUserNameKana();
        this.searchUserName = user.getUserName().replaceAll("　| ", "");
        this.userType = user.getUserType();
        this.debutDt = user.getDebutDt();
        this.debutDtStr = Util.formatLocalDateTime(user.getDebutDt(), DateFormatEnum.HYPHEN_YM);
        this.gender = user.getGender();
        this.officeId = user.getOfficeId().getId();
        this.officeName = user.getOfficeId().getOfficeName();
        this.areaId = user.getAreaId().getId();
        this.areaName = user.getAreaId().getAreaName();
        this.selfIntroduction = user.getSelfIntroduction();
        this.profileImgPath = user.getProfileImgPath();
        this.loginAt = user.getLoginAt();
        this.loginAtInt = Util.getFormatLocalDateTimeToInt(loginAt);
        this.updateAt = user.getUpdateAt();
        this.updateAtInt = Util.getFormatLocalDateTimeToInt(updateAt);
        this.setActivityNum();
        this.feeType = user.getComposerProfile().getFeeType();
        this.fee = user.getComposerProfile().getFee();
        this.memberNum = user.getComedianProfile().getMemberNum();
        this.matchStatus = user.getMatchStatus();
        if (user.getComedyStyleIds() != null) {
            this.comedyStyleIdList = Util.toIntList(user.getComedyStyleIds());
            this.comedyStyleNameList = Util.toStrList(user.getComedyStyleNames());
        }
        if (user.getSpecialSkillIds() != null) {
            this.specialSkillIdList = Util.toIntList(user.getSpecialSkillIds());
            this.specialSkillNameList = Util.toStrList(user.getSpecialSkillNames());
        }
        if (user.getAnotherSkillNames() != null) {
            this.anotherSkill = user.getAnotherSkillNames();
        }
    }

    /**
     * IDを取得します。
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * IDを設定します。
     * @param id ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * ユーザ名を取得します。
     * @return ユーザ名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザ名を設定します。
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * ユーザ名(かな)を取得します。
     * @return ユーザ名(かな)
     */
    public String getUserNameKana() {
        return userNameKana;
    }

    /**
     * ユーザ名(かな)を設定します。
     * @param userNameKana ユーザ名(かな)
     */
    public void setUserNameKana(String userNameKana) {
        this.userNameKana = userNameKana;
    }

    /**
     * 検索用ユーザ名を取得します。
     * @return 検索用ユーザ名
     */
    public String getSearchUserName() {
        return searchUserName;
    }

    /**
     * 検索用ユーザ名を設定します。
     * @param searchUserName 検索用ユーザ名
     */
    public void setSearchUserName(String searchUserName) {
        this.searchUserName = searchUserName;
    }

    /**
     * 活動種別を取得します。
     * @return 活動種別
     */
    public int getUserType() {
        return userType;
    }

    /**
     * 活動種別を設定します。
     * @param userType 活動種別
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * 活動開始年月を取得します。
     * @return 活動開始年月
     */
    public LocalDate getDebutDt() {
        return debutDt;
    }

    /**
     * 活動開始年月を設定します。
     * @param debutDt 活動開始年月
     */
    public void setDebutDt(LocalDate debutDt) {
        this.debutDt = debutDt;
    }

    /**
     * 活動開始年月(YYYY-MM)を取得します。
     * @return 活動開始年月(YYYY-MM)
     */
    public String getDebutDtStr() {
        return debutDtStr;
    }

    /**
     * 活動開始年月(YYYY-MM)を設定します。
     * @param debutDtStr 活動開始年月(YYYY-MM)
     */
    public void setDebutDtStr(String debutDtStr) {
        this.debutDtStr = debutDtStr;
    }

    /**
     * 活動年月を取得します。
     * @return 活動年月
     */
    public String getActivityDt() {
        return activityDt;
    }

    /**
     * 活動年月を設定します。
     * @param activityDt 活動年月
     */
    public void setActivityDt(String activityDt) {
        this.activityDt = activityDt;
    }

    /**
     * 活動年数を取得します。
     * @return 活動年数
     */
    public int getActivityNum() {
        return activityNum;
    }

    /**
     * 活動年数を設定します。
     * @param activityNum 活動年数
     */
    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }

    /**
     * 性別を取得します。
     * @return 性別
     */
    public int getGender() {
        return gender;
    }

    /**
     * 性別を設定します。
     * @param gender 性別
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 事務所IDを取得します。
     * @return 事務所ID
     */
    public int getOfficeId() {
        return officeId;
    }

    /**
     * 事務所IDを設定します。
     * @param officeId 事務所ID
     */
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    /**
     * オフィス名を取得します。
     * @return オフィス名
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * オフィス名を設定します。
     * @param officeName オフィス名
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * 活動場所IDを取得します。
     * @return 活動場所ID
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * 活動場所IDを設定します。
     * @param areaId 活動場所ID
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    /**
     * 活動地域名を取得します。
     * @return 活動地域名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 活動地域名を設定します。
     * @param areaName 活動地域名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 自己紹介文を取得します。
     * @return 自己紹介文
     */
    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    /**
     * 自己紹介文を設定します。
     * @param selfIntroduction 自己紹介文
     */
    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }


    /**
     * プロフィール画像を取得します。
     * @return プロフィール画像
     */
    public String getProfileImgPath() {
        return profileImgPath;
    }

    /**
     * プロフィール画像を設定します。
     * @param profileImgPath プロフィール画像
     */
    public void setProfileImgPath(String profileImgPath) {
        this.profileImgPath = profileImgPath;
    }

    /**
     * ログイン日時を取得します。
     * @return ログイン日時
     */
    public LocalDateTime getLoginAt() {
        return loginAt;
    }

    /**
     * ログイン日時を設定します。
     * @param loginAt ログイン日時
     */
    public void setLoginAt(LocalDateTime loginAt) {
        this.loginAt = loginAt;
    }

    /**
     * ログイン日時 並び替え用を取得します。
     * @return ログイン日時 並び替え用
     */
    public Integer getLoginAtInt() {
        return loginAtInt;
    }

    /**
     * ログイン日時 並び替え用を設定します。
     * @param loginAtInt ログイン日時 並び替え用
     */
    public void setLoginAtInt(Integer loginAtInt) {
        this.loginAtInt = loginAtInt;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    /**
     * 更新日時を設定します。
     * @param updateAt 更新日時
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 更新日時 並び替え用を取得します。
     * @return 更新日時 並び替え用
     */
    public Integer getUpdateAtInt() {
        return updateAtInt;
    }

    /**
     * 更新日時 並び替え用を設定します。
     * @param updateAtInt 更新日時 並び替え用
     */
    public void setUpdateAtInt(Integer updateAtInt) {
        this.updateAtInt = updateAtInt;
    }

    /**
     * 活動人数を取得します。
     * @return 活動人数
     */
    public int getMemberNum() {
        return memberNum;
    }

    /**
     * 活動人数を設定します。
     * @param memberNum 活動人数
     */
    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    /**
     * 料金体系を取得します。
     * @return 料金体系
     */
    public int getFeeType() {
        return feeType;
    }

    /**
     * 料金体系を設定します。
     * @param feeType 料金体系
     */
    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    /**
     * 料金を取得します。
     * @return 料金
     */
    public int getFee() {
        return fee;
    }

    /**
     * 料金を設定します。
     * @param fee 料金
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * 得意分野一覧を取得します。
     * @return 得意分野一覧
     */
    public List<Integer> getComedyStyleIdList() {
        return comedyStyleIdList;
    }

    /**
     * 得意分野一覧を設定します。
     * @param comedyStyleIdList 得意分野一覧
     */
    public void setComedyStyleIdList(List<Integer> comedyStyleIdList) {
        this.comedyStyleIdList = comedyStyleIdList;
    }

    /**
     * コメディスタイル名を取得します。
     * @return コメディスタイル名
     */
    public List<String> getComedyStyleNameList() {
        return comedyStyleNameList;
    }

    /**
     * コメディスタイル名を設定します。
     * @param comedyStyleName コメディスタイル名
     */
    public void setComedyStyleName(List<String> comedyStyleName) {
        this.comedyStyleNameList = comedyStyleName;
    }

    /**
     * 特殊スキル一覧を取得します。
     * @return 特殊スキル一覧
     */
    public List<Integer> getSpecialSkillIdList() {
        return specialSkillIdList;
    }

    /**
     * 特殊スキル一覧を設定します。
     * @param specialSkillIdList 特殊スキル一覧
     */
    public void setSpecialSkillIdList(List<Integer> specialSkillIdList) {
        this.specialSkillIdList = specialSkillIdList;
    }

    /**
     * 特殊スキル名を取得します。
     * @return 特殊スキル名
     */
    public List<String> getSpecialSkillNameList() {
        return specialSkillNameList;
    }

    /**
     * 特殊スキル名を設定します。
     * @param specialSkillNameList 特殊スキル名
     */
    public void setSpecialSkillNameList(List<String> specialSkillNameList) {
        this.specialSkillNameList = specialSkillNameList;
    }

    /**
     * その他特殊スキルを取得します。
     * @return その他特殊スキル
     */
    public String getAnotherSkill() {
        return anotherSkill;
    }

    /**
     * その他特殊スキルを設定します。
     * @param anotherSpecialSkill その他特殊スキル
     */
    public void setAnotherSkill(String anotherSkill) {
        this.anotherSkill = anotherSkill;
    }

    /**
     * idトークンを取得します。
     * @return idトークン
     */
    public String getIdToken() {
        return idToken;
    }

    /**
     * idトークンを設定します。
     * @param idToken idトークン
     */
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    /**
     * リフレッシュトークンを取得します。
     * @return リフレッシュトークン
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * リフレッシュトークンを設定します。
     * @param refreshToken リフレッシュトークン
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * matchStatusを取得します。
     * @return matchStatus
     */
    public Integer getMatchStatus() {
        return matchStatus;
    }

    /**
     * matchStatusを設定します。
     * @param matchStatus セットする matchStatus
     */
    public void setMatchStatus(Integer matchStatus) {
        this.matchStatus = matchStatus;
    }

    /**
     * 活動年月のセット処理  作家・芸人共通
     * @param users
     */
    private void setActivityNum() {
        // 現在日付を取得
        LocalDate date = LocalDate.now();
        // 現在日付と活動開始年月の差分を取得
        LocalDate differenceYear = date.minusYears(this.getDebutDt().getYear());
        LocalDate differenceDate = differenceYear.minusMonths(this.getDebutDt().getMonthValue());
        if (differenceDate.getMonthValue() == 12) {
            differenceDate = differenceDate.plusYears(1);
        }
        // String型に変換
        String activityYear = Integer.valueOf(differenceDate.getYear()).toString();
        String activityMonth = Integer.valueOf(differenceDate.getMonthValue()).toString();

        if(date.getYear() == this.getDebutDt().getYear() && date.getMonthValue() == this.getDebutDt().getMonthValue()) {
            // デビューした年月が今月の場合は0年0ヶ月目
            // このようにしないと、上の計算方法では－1年12ヶ月目と計算されてしまう
            activityYear = "0";
            activityMonth = "0";
        }

        String activityDate;
        // 活動年数
        int activityNum = differenceDate.getYear();
        // 画面表示用にセット
        if (differenceDate.getMonthValue() == 12) {
            activityDate = activityYear + "年 ";
        } else if(differenceDate.getMonthValue() != 12 && 0 < differenceDate.getYear()) {
            activityDate = activityYear + "年 " + activityMonth + "ヶ月" ;
        } else {
            activityDate = activityMonth + "ヶ月 " ;
        }
        this.activityDt = activityDate;
        this.activityNum = activityNum;
    }

}
package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *Profileテーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 */
public class Profile {

    /** ID */
    private int id;
    /** ユーザアドレス */
    private String user_address;
    /** ユーザ名 */
    private String user_name;
    /** ユーザ名(かな) */
    private String user_name_kana;
    /** 活動種別 */
    private int user_type;
    /** パスワード */
    private String password;
    /** 退会フラグ */
    private int delete_flg;
    /** ログイン日時 */
    private LocalDateTime login_at;
    /** 作成日時 */
    private LocalDateTime create_at;
    /** 更新日時 */
    private LocalDateTime update_at;


 // ---------comedianの要素(comedianBeanに移動させたほうが良い？？)-----------
    /** ユーザID */
    private int user_id;
    /** 活動開始年月 */
    private Date debut_dt;
    /** 活動人数 */
    private int member_num;
    /** 性別 */
    private int gender;
    /** 事務所 */
    private String belong;
    /** 活動場所 */
    private int active_place;
    /** 自己紹介文 */
    private String self_introduction;
    /** プロフィール画像 */
    private String profile_img_path;
    // ------------------------------------------------------------------------

    // ---------composerの要素(composerBeanに移動させたほうが良い？？)-----------
    /** 料金体系 */
    private int fee_type;
    /** 料金 */
    private int fee;
    /** 特殊スキル */
    private String skill;
    // ------------------------------------------------------------------------


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
     * @return user_address
     */
    public String getUser_address() {
        return user_address;
    }
    /**
     * @param user_address セットする user_address
     */
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    /**
     * @return user_name
     */
    public String getUser_name() {
        return user_name;
    }
    /**
     * @param user_name セットする user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    /**
     * @return user_name_kana
     */
    public String getUser_name_kana() {
        return user_name_kana;
    }
    /**
     * @param user_name_kana セットする user_name_kana
     */
    public void setUser_name_kana(String user_name_kana) {
        this.user_name_kana = user_name_kana;
    }
    /**
     * @return user_type
     */
    public int getUser_type() {
        return user_type;
    }
    /**
     * @param user_type セットする user_type
     */
    public void setUser_type(int user_type) {
        this.user_type = user_type;
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
        this.password = password;
    }
    /**
     * @return delete_flg
     */
    public int getDelete_flg() {
        return delete_flg;
    }
    /**
     * @param delete_flg セットする delete_flg
     */
    public void setDelete_flg(int delete_flg) {
        this.delete_flg = delete_flg;
    }
    /**
     * @return login_at
     */
    public LocalDateTime getLogin_at() {
        return login_at;
    }
    /**
     * @param login_at セットする login_at
     */
    public void setLogin_at(LocalDateTime login_at) {
        this.login_at = login_at;
    }
    /**
     * @return create_at
     */
    public LocalDateTime getCreate_at() {
        return create_at;
    }
    /**
     * @param create_at セットする create_at
     */
    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }
    /**
     * @return update_at
     */
    public LocalDateTime getUpdate_at() {
        return update_at;
    }
    /**
     * @param update_at セットする update_at
     */
    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }





    /**
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }
    /**
     * @param user_id セットする user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    /**
     * @return debut_dt
     */
    public Date getDebut_dt() {
        return debut_dt;
    }
    /**
     * @param debut_dt セットする debut_dt
     */
    public void setDebut_dt(Date debut_dt) {
        this.debut_dt = debut_dt;
    }
    /**
     * @return member_num
     */
    public int getMember_num() {
        return member_num;
    }
    /**
     * @param member_num セットする member_num
     */
    public void setMember_num(int member_num) {
        this.member_num = member_num;
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
     * @return belong
     */
    public String getBelong() {
        return belong;
    }
    /**
     * @param belong セットする belong
     */
    public void setBelong(String belong) {
        this.belong = belong;
    }
    /**
     * @return active_place
     */
    public int getActive_place() {
        return active_place;
    }
    /**
     * @param active_place セットする active_place
     */
    public void setActive_place(int active_place) {
        this.active_place = active_place;
    }
    /**
     * @return self_introduction
     */
    public String getSelf_introduction() {
        return self_introduction;
    }
    /**
     * @param self_introduction セットする self_introduction
     */
    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }
    /**
     * @return profile_img_path
     */
    public String getProfile_img_path() {
        return profile_img_path;
    }
    /**
     * @param profile_img_path セットする profile_img_path
     */
    public void setProfile_img_path(String profile_img_path) {
        this.profile_img_path = profile_img_path;
    }






    /**
     * @return fee_type
     */
    public int getFee_type() {
        return fee_type;
    }
    /**
     * @param fee_type セットする fee_type
     */
    public void setFee_type(int fee_type) {
        this.fee_type = fee_type;
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
     * @return skill
     */
    public String getSkill() {
        return skill;
    }
    /**
     * @param skill セットする skill
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }


}

package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.controller.bean.req.ProfileBean;
import com.c4ccup.laugh.domain.User;

/**
 * ユーザー I/Fクラス
 *
 */
@Mapper
public interface UserRepository {

    /**
     * データを取得
     *
     * @param id
     * @return User
     */
    public User findById(Integer id);

    /**
     * メールアドレスでユーザーを取得
     *
     * @param mail
     * @return User
     */
    public User findByMail(String mail);

    /**
     * userテーブルにデータを追加する
     * @param UserBean
     * @return user_id
     */
    public void register(ProfileBean userBean);

    /**
     * comedian_profileテーブルにデータを追加する
     * @param UserBean
     */
    public void registerComedian(ProfileBean userBean);

    /**
     * composer_profileテーブルにデータを追加する
     * @param UserBean
     */
    public void registerComposer(ProfileBean userBean);

    /**
     * own_comedy_styleテーブルにデータを追加する
     * @param UserBean
     */
    public void registerOwnComedyStyle(ProfileBean userBean);

    /**
     * own_special_skillテーブルにデータを追加する
     * @param UserBean
     */
    public void registerOwnSpecialSkill(@Param("userBeanList") List<ProfileBean> userBeanList);

    /**
     * 氏名でユーザーを取得
     *
     * @param name
     * @return User
     */
    public List<User> findByName(String name);

    /**
     * ログイン日時を更新
     *
     * @param User
     */
    public void updateLoginAt(User user);

    /**
     * ユーザータイプで作家ユーザーを取得
     *
     * @param userBean
     * @return User
     */
    public List<User> getComposerList(int userType);

    /**
     * ユーザータイプで芸人ユーザーを取得
     *
     * @param userBean
     * @return User
     */
    public List<User> getComedianList(int userType);

    /**
     * ユーザーIDで作家ユーザーを取得
     *
     * @param userBean
     * @return User
     */
    public User getComposer(int id);

    /**
     * ユーザーIDで芸人ユーザーを取得
     *
     * @param userBean
     * @return User
     */
    public User getComedian(int id);

    /**
     * userテーブルのデータを更新する
     * @param userId
     */
    public void updateProfile(ProfileBean bean);

    /**
     * comedian_profileテーブルのデータを更新する
     * @param userId
     */
    public void updateComedian(ProfileBean bean);

    /**
     * composer_profileテーブルのデータを更新する
     * @param userId
     */
    public void updateComposer(ProfileBean bean);

    /**
     * own_comedy_styleテーブルのデータを物理削除する
     * @param userId
     */
    public void deleteOwnComedyStyle(int userId);

    /**
     * own_special_skillテーブルのデータを物理削除する
     * @param userId
     */
    public void deleteOwnSpecialSkill(int userId);
}


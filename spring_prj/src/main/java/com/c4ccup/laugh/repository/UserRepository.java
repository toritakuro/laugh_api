package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.c4ccup.laugh.controller.bean.UserBean;
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
    public void register(UserBean userBean);

    /**
     * comedian_profileテーブルにデータを追加する
     * @param UserBean
     */
    public void registerComedian(UserBean userBean);

    /**
     * composer_profileテーブルにデータを追加する
     * @param UserBean
     */
    public void registerComposer(UserBean userBean);

    /**
     * own_comedy_styleテーブルにデータを追加する
     * @param UserBean
     */
    public void registerOwnComedyStyle(UserBean userBean);

    /**
     * own_special_skillテーブルにデータを追加する
     * @param UserBean
     */
    public void registerOwnSpecialSkill(@Param("userBeanList") List<UserBean> userBeanList);

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
}

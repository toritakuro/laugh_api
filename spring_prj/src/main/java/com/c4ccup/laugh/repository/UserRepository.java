package com.c4ccup.laugh.repository;

import org.apache.ibatis.annotations.Mapper;

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
     * ログイン日時を更新
     * 
     * @param User
     */
    public void updateLoginAt(User user);
}

package com.c4ccup.laugh.repository;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.domain.User;

@Mapper
public interface UserRepository {

    /**
     * データを取得
     *@param id
     *@return User
     */
    public User findById(Integer id);

    /**
     * メールアドレスでユーザーを取得
     *@param mail, password
     *@return User
     */
    public User findByMail(String mail);
}

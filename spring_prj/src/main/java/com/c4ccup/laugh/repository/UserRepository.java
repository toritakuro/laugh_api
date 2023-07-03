package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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

    public List<User> getComposerList(UserBean userBean);
    public List<User> getComedianList(UserBean userBean);
    public List<User> initByid(UserBean userBean);
    
    public List<User> init();
}


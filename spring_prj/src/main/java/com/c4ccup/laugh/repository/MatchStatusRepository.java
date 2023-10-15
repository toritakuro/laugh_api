package com.c4ccup.laugh.repository;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.bean.req.UserDetailBean;

/**
 * マッチステータス I/Fクラス
 *
 */
@Mapper
public interface MatchStatusRepository {

    /**
     * マッチステータスを登録
     *
     * @param bean 
     */
    public void regMatchStatus(UserDetailBean bean);

}

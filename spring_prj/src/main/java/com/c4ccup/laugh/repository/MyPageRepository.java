
package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.domain.Laugh;

/**
 * マイページ I/Fクラス
 *
 */
@Mapper
public interface MyPageRepository {

    /**
     * Laugh一覧を取得
     *
     * @param userId
     * @return
     */
    public List<Laugh> selectLaugh(int userId);

    /**
     * マッチステータスを取得
     *
     * @param sendUserId
     * @param receiveUserId
     * @return
     */
    public Laugh selectMatchStatus(int sendUserId, int receiveUserId);
}

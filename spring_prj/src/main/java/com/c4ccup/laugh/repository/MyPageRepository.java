
package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
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
     * contentsテーブルにデータを追加する
     *
     * @param myPageBean
     */
    public void uploadFile(MyPageBean myPageBean);

}

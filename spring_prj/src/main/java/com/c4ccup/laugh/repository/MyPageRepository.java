
package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.domain.Content;
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
     * contentテーブルにデータを追加する
     *
     * @param myPageBean
     */
    public void uploadContent(MyPageBean myPageBean);

    /**
     * content一覧を取得
     *
     * @param userId
     * @return
     */
    public List<Content> selectContent(int userId);

    /**
     * contentテーブルのデータを編集する
     *
     * @param myPageBean
     */
    public void editContent(MyPageBean myPageBean);

    /**
     * contentテーブルからデータを削除する
     *
     * @param id
     */
    public void deleteContent(int id);

}

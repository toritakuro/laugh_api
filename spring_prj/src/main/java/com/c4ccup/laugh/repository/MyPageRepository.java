
package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.bean.req.MyPageBean;
import com.c4ccup.laugh.controller.bean.req.UserDetailBean;
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
     * マッチステータスを取得
     *
     * @param bean
     * @return
     */
    public Laugh selectMatchStatus(UserDetailBean bean);

    /**
     * ユーザ詳細用の投稿一覧を取得
     *
     * @param bean
     * @return
     */
    public List<Content> selectContent(MyPageBean bean);
}

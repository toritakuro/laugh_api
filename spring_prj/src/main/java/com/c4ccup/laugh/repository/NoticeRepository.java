package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.c4ccup.laugh.domain.Notice;

/**
 * お知らせ I/Fクラス
 *
 */
@Mapper
public interface NoticeRepository {

    /**
     * お知らせ一覧を取得
     *
     * @param userId
     * @return List<Notice>
     */
    public List<Notice> findById(int userId);

    /**
     * 既読処理
     * @param id
     */
    public void read(int id);

    /**
     * お知らせ作成
     * @param notice
     */
    public void create(Notice notice);
}


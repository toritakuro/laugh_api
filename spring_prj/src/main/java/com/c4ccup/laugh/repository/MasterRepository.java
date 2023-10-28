package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.domain.Area;
import com.c4ccup.laugh.domain.Office;

@Mapper
public interface MasterRepository {

    /**
     * 事務所一覧を取得する。
     * @return
     */
    public List<Office> findOfficeList();

    /**
     * 活動場所一覧を取得する。
     * @return
     */
    public List<Area> findAreaList();
}

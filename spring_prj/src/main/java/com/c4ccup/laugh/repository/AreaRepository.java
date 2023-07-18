package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.domain.Area;

@Mapper
public interface AreaRepository {

    public List<Area> getAreaList();
}

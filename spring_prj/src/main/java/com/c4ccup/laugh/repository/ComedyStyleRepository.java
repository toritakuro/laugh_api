package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.domain.ComedyStyle;

@Mapper
public interface ComedyStyleRepository {

    public List<ComedyStyle> getComedyStyleList();
}

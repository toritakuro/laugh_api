package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComedianRepository {

    public List<String> getBelongList();
}

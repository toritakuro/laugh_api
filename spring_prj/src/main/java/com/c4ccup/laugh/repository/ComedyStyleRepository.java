package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComedyStyleRepository {

    public List<String> getcomedyStyleList();
}

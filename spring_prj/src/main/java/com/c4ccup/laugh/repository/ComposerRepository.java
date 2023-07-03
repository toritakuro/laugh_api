package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComposerRepository {

    public List<String> getBelongList();
    
    public List<Integer> getFeeList();
    
    public List<String> getSkillList();
}

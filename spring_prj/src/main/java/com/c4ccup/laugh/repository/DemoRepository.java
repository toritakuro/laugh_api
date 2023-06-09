package com.c4ccup.laugh.repository;

import org.apache.ibatis.annotations.Mapper;
import com.c4ccup.laugh.domain.Demo;

@Mapper
public interface DemoRepository {

    // @Select("SELECT id, title FROM DEMO WHERE id = #{id}")
    public Demo findById(Integer id);
    public void isert();
}

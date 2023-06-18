package com.c4ccup.laugh.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c4ccup.laugh.controller.bean.DemoBean;
import com.c4ccup.laugh.domain.Demo;

@Mapper
public interface DemoRepository {

    /**
     * データを取得する
     *@param demoBean DemoBean型の要素
     *@return Demo
     */
    public Demo findById(Integer id);

    /**
     * データを追加する
     *@param demoBean DemoBean型の要素
     */
    public void insert(DemoBean demoBean);

    /**
     * データを上書きする
     *@param demoBean DemoBean型の要素
     */
    public void update(DemoBean demoBean);

    /**
     * DEMOテーブルの全てのデータを取得する
     * @return List<Demo>
     */
    public List<Demo> findAll();

    /**
     * DEMO.idをキーに職業データを取得する
     *@param demoBean DemoBean型の要素
     *@return Demo
     */
    public Demo findWorkById(Integer id);

    /**
     * 職業を含んだ全てのデータを取得する
     * @return List<Demo>
     */
    public List<Demo> findAllWork();
}

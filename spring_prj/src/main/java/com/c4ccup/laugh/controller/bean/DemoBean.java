package com.c4ccup.laugh.controller.bean;

/**
 *画面から取得した値をJavaオブジェクトで扱うためのクラス
 */
public class DemoBean {
	
    /** id */
    private int id;
    /** tittle */
    private String title;
    
    
    /**
     * idを取得します。
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * idを設定します。
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * tittleを取得します。
     * @return tittle
     */
    public String getTitle() {
        return title;
    }
    /**
     * tittleを設定します。
     * @param title tittle
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
package com.c4ccup.laugh.controller.bean.res;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MasterResource {

    /** id */
    private int id;
    /** 名前 */
    private String name;



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
     * 名前を取得します。
     * @return 名前
     */
    public String getName() {
        return name;
    }
    /**
     * 名前を設定します。
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

}

package com.c4ccup.laugh.controller.bean.res;

import java.util.List;

import com.c4ccup.laugh.domain.Demo;

public class DemoResources extends _Cmn {

    private int id;
    private String title;
    private List<Demo> demolist;

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
     * titleを取得します。
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * titleを設定します。
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * demolistを取得します。
     * @return demolist
     */
    public List<Demo> getDemolist() {
        return demolist;
    }
    /**
     * demolistを設定します。
     * @param demolist demolist
     */
    public void setDemolist(List<Demo> demolist) {
        this.demolist = demolist;
    }

}

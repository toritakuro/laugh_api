package com.c4ccup.laugh.controller.bean;

import javax.validation.constraints.NotNull;

/**
 *画面から取得した値をJavaオブジェクトで扱うためのクラス
 */
public class DemoBean {

    /** id */
    @NotNull(message = "idは必須です")
    private Integer id;
    /** tittle */
    private String title;
    /** detailIds */
    private int detailIds;


	/**
     * idを取得します。
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * idを設定します。
     * @param id id
     */
    public void setId(Integer id) {
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
    /**
	 * @return detailIds
	 */
	public int getDetailIds() {
		return detailIds;
	}
	/**
	 * @param detailIds セットする detailIds
	 */
	public void setDetailIds(int detailIds) {
		this.detailIds = detailIds;
	}
}
package com.c4ccup.laugh.domain;


/**
 *Demoテーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 */
public class Demo {

    /** id */
    private int id;
    /** tittle */
    private String title;
    /** detailIds */
    private DemoDetail detailIds;


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
    /**
	 * @return detailIds
	 */
	public DemoDetail getDetailIds() {
		return detailIds;
	}
	/**
	 * @param detailIds セットする detailIds
	 */
	public void setDetailIds(DemoDetail detailIds) {
		this.detailIds = detailIds;
	}
}

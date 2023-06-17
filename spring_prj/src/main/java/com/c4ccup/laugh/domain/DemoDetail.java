package com.c4ccup.laugh.domain;


/**
 *DemoDetailテーブルのカラムの値をJavaオブジェクトで扱うためのクラス
 */
public class DemoDetail {
	
	private String detailId;
    private String work;
    
    
	/**
	 * @return detailId
	 */
	public String getDetailId() {
		return detailId;
	}
	/**
	 * @param detailId セットする detailId
	 */
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	/**
	 * @return work
	 */
	public String getWork() {
		return work;
	}
	/**
	 * @param work セットする work
	 */
	public void setWork(String work) {
		this.work = work;
	}
}

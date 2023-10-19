package com.c4ccup.laugh.controller.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 *画面から取得した値をJavaオブジェクトで扱うためのクラス
 */
public class DemoBean {

    /** id */
    @NotNull
    private Integer id;
    /** tittle */
    @NotNull
    private String title;
    /** detailIds */
    private int detailIds;
    /** デモファイル */
    private MultipartFile file;

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
//    /**
//     * fileを取得します。
//     * @return file
//     */
//    public MultipartFile getFile() {
//        return file;
//    }
//    /**
//     * fileを設定します。
//     * @param file file
//     */
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }
    /**
     * fileを取得します。
     * @return file
     */
    public MultipartFile getFile() {
        return file;
    }
    /**
     * fileを設定します。
     * @param file file
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * 相関チェック(メソッド名がfield名になる)
     * @return
     */
    @AssertTrue(message = "だめだこりゃ")
    public boolean isMessageNotEmptyIfToPresents() {
        return false;
    }
}
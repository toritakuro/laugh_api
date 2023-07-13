package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class OwnComedyStyle {

    /** id */
    private int id;
    /** ユーザid */
    private int userId;
    /** 芸風id */
    private ComedyStyle comedyStyleId;
    /** 作成日時 */
    private LocalDateTime createAt;
    /** 更新日時 */
    private LocalDateTime updateAt;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id セットする id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * @return comedyStyleId
     */
    public ComedyStyle getComedyStyleId() {
        return comedyStyleId;
    }
    /**
     * @param comedyStyleId セットする comedyStyleId
     */
    public void setComedyStyleId(ComedyStyle comedyStyleId) {
        this.comedyStyleId = comedyStyleId;
    }
    /**
     * @return createAt
     */
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    /**
     * @param createAt セットする createAt
     */
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    /**
     * @return updateAt
     */
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    /**
     * @param updateAt セットする updateAt
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

}

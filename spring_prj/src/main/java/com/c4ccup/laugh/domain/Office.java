package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class Office {

    /** id */
    private int id;
    /** オフィス名 */
    private String officeName;
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
     * @return officeName
     */
    public String getOfficeName() {
        return officeName;
    }
    /**
     * @param officeName セットする officeName
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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

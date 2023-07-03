package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class ComedyStyle {

    public int id;
    public String styleName;
    public LocalDateTime createAt;
    public LocalDateTime updateAt;
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
     * @return styleName
     */
    public String getStyleName() {
        return styleName;
    }
    /**
     * @param styleName セットする styleName
     */
    public void setStyleName(String styleName) {
        this.styleName = styleName;
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

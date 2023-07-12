package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class SpecialSkill {

    /** id */
    private int id;
    /** スキル名 */
    private String specialSkillName;
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
     * @return specialSkillName
     */
    public String getSpecialSkillName() {
        return specialSkillName;
    }
    /**
     * @param specialSkillName セットする specialSkillName
     */
    public void setSpecialSkillName(String specialSkillName) {
        this.specialSkillName = specialSkillName;
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

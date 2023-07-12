package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class OwnSpecialSkill {

    /** id */
    private int id;
    /** ユーザid */
    private int userId;
    /** スキルid */
    private SpecialSkill specialSkillId;
    /** その他スキル名 */
    private String anotherSkillName;
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
     * @return specialSkillId
     */
    public SpecialSkill getSpecialSkillId() {
        return specialSkillId;
    }
    /**
     * @param specialSkillId セットする specialSkillId
     */
    public void setSpecialSkillId(SpecialSkill specialSkillId) {
        this.specialSkillId = specialSkillId;
    }
    /**
     * @return anotherSkillName
     */
    public String getAnotherSkillName() {
        return anotherSkillName;
    }
    /**
     * @param anotherSkillName セットする anotherSkillName
     */
    public void setAnotherSkillName(String anotherSkillName) {
        this.anotherSkillName = anotherSkillName;
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

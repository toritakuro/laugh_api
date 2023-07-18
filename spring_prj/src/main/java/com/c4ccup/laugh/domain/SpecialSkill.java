package com.c4ccup.laugh.domain;

public class SpecialSkill {

    /** id */
    private int id;
    /** スキル名 */
    private String specialSkillName;

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
}

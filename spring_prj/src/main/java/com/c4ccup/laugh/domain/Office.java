package com.c4ccup.laugh.domain;

public class Office {

    /** id */
    private int id;
    /** オフィス名 */
    private String officeName;

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
}

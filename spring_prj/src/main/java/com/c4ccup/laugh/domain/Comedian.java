package com.c4ccup.laugh.domain;

import java.time.LocalDateTime;

public class Comedian {

    private int id;
    private int userId;
    private int memberNum;
    private LocalDateTime createAt;
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
     * @return memberNum
     */
    public int getMemberNum() {
        return memberNum;
    }
    /**
     * @param memberNum セットする memberNum
     */
    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
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

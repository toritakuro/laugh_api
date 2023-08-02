package com.c4ccup.laugh.util;

public enum UserTypeEnum {

    COMPOSER(1),
    COMEDIAN(2);

    /** ユーザータイプ */
    private int userType;

    private UserTypeEnum(int userType) {
        this.userType = userType;
    }

    /**
     * @return userType
     */
    public int getUserType() {
        return userType;
    }
}

package com.c4ccup.laugh.domain;

import lombok.Getter;

@Getter
public enum UserTypeEnum {

    COMPOSER(1),
    COMEDIAN(2);

    /** ユーザータイプ */
    private int userType;

    private UserTypeEnum(int userType) {
        this.userType = userType;
    }
    public int getUserTypeAsInt() {
        return userType;
    }
//    public static UserTypeEnum toCode(String userType) {
//        
//        for (UserTypeEnum enumValue : UserTypeEnum.values()) {
//            if (userType != null && userType.equals(enumValue.toString())) {
//                return enumValue;
//            }
//        }
//        return UserTypeEnum.UNKNOWN;
//    }
    
}

package com.c4ccup.laugh.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * パスワード Utilクラス
 *
 */
public class PasswordUtil {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * パスワードのハッシュ化
     * 
     * @param password ハッシュ化するパスワード
     * @return hash化されたパスワード
     */
    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * 平文パスワードとハッシュ化されたパスワードの一致検証
     * 
     * @param rawPassword     平文パスワード
     * @param encodedPassword ハッシュ化されたパスワード
     * @return パスワードが一致する場合はtrue、それ以外の場合はfalse
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
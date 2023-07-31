package com.c4ccup.laugh.util;

import java.util.Locale;

import javax.security.auth.login.LoginException;

import org.springframework.context.MessageSource;
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
    public static void matches(String rawPassword, String encodedPassword, MessageSource messageSource)
            throws LoginException {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            String errMsg = messageSource.getMessage("e001", new Object[] { "パスワード認証" }, Locale.JAPAN);
            throw new LoginException(errMsg);
        }
    }
}
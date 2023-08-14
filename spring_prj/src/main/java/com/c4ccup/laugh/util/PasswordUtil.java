package com.c4ccup.laugh.util;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * パスワード Utilクラス
 *
 */
public class PasswordUtil {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    MessageUtil msgUtil;

    /**
     * パスワードのハッシュ化
     * 
     * @param password ハッシュ化するパスワード
     * @return ハッシュ化されたパスワード
     */
    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * 平文パスワードとハッシュ化されたパスワードの一致検証
     * 
     * @param rawPassword     平文パスワード
     * @param encodedPassword ハッシュ化されたパスワード
     * @param messageSource   メッセージソース
     */
    public void matches(String rawPassword, String encodedPassword) throws LoginException {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            String errMsg = msgUtil.getMessage("e001", "パスワード認証");
            throw new LoginException(errMsg);
        }
    }
}
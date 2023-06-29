package com.c4ccup.laugh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.c4ccup.laugh.util.JwtUtil;
import com.c4ccup.laugh.util.PasswordUtil;

/**
 * Bean Configuration クラス
 *
 */
@Configuration
public class BeanConfig {

    /**
     * JwtUtilのBeanを作成
     *
     * @return JwtUtilのインスタンス
     */
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    /**
     * PasswordUtilのBeanを作成
     *
     * @return PasswordUtilのインスタンス
     */
    @Bean
    public PasswordUtil passwordUtil() {
        return new PasswordUtil();
    }
}

package com.c4ccup.laugh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000")
//	            .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*").allowCredentials(true);
    }

    /**
     * インターセプターを追加
     * 
     * @param registry インターセプターを保持するInterceptorRegistryオブジェクト
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).excludePathPatterns("/login", "/register"); // トークン検証をスキップするパスを指定
    }
}
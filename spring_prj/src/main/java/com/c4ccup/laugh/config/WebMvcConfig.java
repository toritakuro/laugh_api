package com.c4ccup.laugh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
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
        registry.addInterceptor(tokenInterceptor).excludePathPatterns("/login", "/profile/register", "/profile/editInit"); // トークン検証をスキップするパスを指定
    }

    /**
     * ValidationMessagesの日本語対応
     */
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        // メッセージファイルを読込むための設定を記載します
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // 「setBasename」を使用することで任意のファイル名に変更することも可能です
        messageSource.setBasename("classpath:ValidationMessages");
        // 「setDefaultEncoding」を使用することで任意の文字コードに変更することも可能です
        messageSource.setDefaultEncoding("UTF-8");
        validator.setValidationMessageSource(messageSource);
        return validator;
    }
}
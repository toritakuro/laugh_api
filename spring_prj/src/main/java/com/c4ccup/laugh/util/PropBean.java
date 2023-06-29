package com.c4ccup.laugh.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * プロパティーファイル用のbeanクラス
 * application.propertiesにconfig.hogeと宣言し、マッピングすることで呼び出し可能
 */
@Component
@ConfigurationProperties(prefix = "config")
public class PropBean {

    private String email;

    /**
     * emailを取得する
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * emailを設定する
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}

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

    /** email */
    private String email;
    /** s3の共通URL */
    private String s3url;
    /** s3バケット */
    private String bucket;



    /**
     * emailを取得します。
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * emailを設定します。
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * s3の共通URLを取得します。
     * @return s3の共通URL
     */
    public String getS3url() {
        return s3url;
    }
    /**
     * s3の共通URLを設定します。
     * @param s3url s3の共通URL
     */
    public void setS3url(String s3url) {
        this.s3url = s3url;
    }
    /**
     * s3バケットを取得します。
     * @return s3バケット
     */
    public String getBucket() {
        return bucket;
    }
    /**
     * s3バケットを設定します。
     * @param bucket s3バケット
     */
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

}

package com.c4ccup.laugh.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Component
public class AwsS3Util {

    @Autowired
    private PropBean prop;

    /** S3Client */
    S3Client s3Client = null;
    /** S3Url */
    private static final String URL ="https://s3-ap-northeast-1.amazonaws.com" ;

    public AwsS3Util () {
        try {
        s3Client = S3Client
            .builder()
            .region(Region.AP_NORTHEAST_1)
            .endpointOverride(new URI(URL))
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();
        } catch (Exception e) {  }
    }

    /**
     * S3へファイルアップロードを行う。
     * @param userId
     * @param file
     * @return s3へアップロードしたファイル名
     */
    public String uploadFile(int userId, MultipartFile file) {
        final String fileName = getS3FileName(file);
        String mimeType = file.getContentType();
        try {
            // metaデータはどのように設定するか不明.metaで設定できる
            // Map<String, String> metadata = new HashMap<>();
            // metadata.put("x-amz-meta-myVal", "test");
            PutObjectRequest putOb = PutObjectRequest.builder()
                .bucket(prop.getBucket())
                .key(userId + "/" + fileName)
                .contentType(mimeType != null ? mimeType : "application/octet-stream")
                .build();
            s3Client.putObject(putOb, RequestBody.fromFile(convert(file)));
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
        catch (S3Exception e) {
            System.err.println(e.getMessage());
        }
        return fileName;
    }


    /**
     * S3へアップロードするファイル名を生成する
     * @param file
     * @return
     */
    private String getS3FileName(MultipartFile file) {
        return this.getRandomStr() + this.getExtention(file.getOriginalFilename());

    }
    /**
     * 16文字のランダムの文字列を生成する
     * @return
     */
    private String getRandomStr() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom RANDOM = new SecureRandom();
        StringBuilder sb = new StringBuilder(16);
        for (int i=0; i < 16; i++) {
              int randomIndex = RANDOM.nextInt(CHARACTERS.length());
              char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    /**
     * ファイルの拡張子を取得する
     * @param name
     * @return
     */
    private String getExtention(String name) {
        return name.substring(name.lastIndexOf("."));
    }

    /**
     * MultipartFileクラスをFileクラスへコンバートする
     * @param multipartFile
     * @return
     */
    private File convert(MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp", null);
        try {
            Files.copy(multipartFile.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

}

package com.c4ccup.laugh.util;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT Utilクラス
 *
 */
public class JwtUtil {

    private final SecretKey secretKey;

    public JwtUtil() {
        // SecretKeyの生成
        this.secretKey = generateSecretKey();
    }

    /**
     * SecretKeyを生成
     *
     * @return SecretKey
     */
    private SecretKey generateSecretKey() {
        try {
            // KeyGeneratorを使用してSecretKeyを生成
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            // エラーハンドリング
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 指定されたsubjectを含むJWTトークンを生成
     * 
     * @param subject JWTのsubject
     * @return 生成されたJWTトークン
     */
    public String generateToken(String subject) {
        return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(secretKey, SignatureAlgorithm.HS256).compact();
    }

    /**
     * 指定されたトークンを検証
     * 
     * @param token 検証するJWTトークン
     * @return トークンが有効であればtrue、無効であればfalse
     */
    public boolean isValidToken(String token) {
        if (token.equals("")) {
            return false;
        }
        try {
            // トークンのデコード、検証処理
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            // デコードしたJWTからクレームを取得する
            Claims claims = claimsJws.getBody();
            Date expirationDate = claims.getExpiration();
            Date currentDate = new Date();

            if (currentDate.after(expirationDate)) {
                // トークンの有効期限切れ
                return false;
            }
            return true; // トークンが有効であればtrueを返す
        } catch (JwtException e) {
            // 無効なトークンの場合は例外が発生する
            return false; // トークンが無効であればfalseを返す
        }
    }
}
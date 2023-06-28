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

public class JwtUtil {

    private final SecretKey secretKey;

    public JwtUtil() {
        // SecretKeyの生成
        this.secretKey = generateSecretKey();
    }

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

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            // トークンのデコード、検証処理
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            // デコードしたJWTからクレームを取得する
            // TODO:トークンから取得した値を使用する？
            Claims claims = claimsJws.getBody();
            String userAddress = claims.getSubject();
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
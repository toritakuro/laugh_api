package com.c4ccup.laugh.util;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

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
            // または例外をスローするなど適切な処理を行う
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
}
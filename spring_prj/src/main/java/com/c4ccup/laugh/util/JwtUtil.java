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
     * idトークンを生成
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
     * リフレッシュトークンを生成
     */
    public String generateRefreshToken(String subject) {
        return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000)))
                .signWith(secretKey, SignatureAlgorithm.HS256).compact();
    }

    /**
     * 指定されたトークンを検証
     * 
     * @param token 検証するJWTトークン
     * @return トークンが有効であればtrue、無効であればfalse
     */
    public boolean isValidToken(String token) {
        // トークンの値のみを抽出
        String tokenVal = "";
        String[] parts = token.split(" ");
        if (parts.length == 2 && parts[0].equals("Bearer")) {
            tokenVal = parts[1];
        }
        try {
            // トークンのデコード、検証処理
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(tokenVal);

            // 有効期限検証のため、デコードしたJWTからクレームを取得する
            Claims claims = claimsJws.getBody();
            Date expirationDate = claims.getExpiration();
            Date currentDate = new Date();
            // トークンの有効期限切れ
            if (currentDate.after(expirationDate)) {
                return false;
            }
            // トークンが有効であればtrueを返す
            return true;
        } catch (JwtException e) {
            // 無効なトークンの場合は例外が発生する
            return false; // トークンが無効であればfalseを返す
        }
    }
}
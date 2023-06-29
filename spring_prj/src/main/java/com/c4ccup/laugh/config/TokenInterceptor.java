package com.c4ccup.laugh.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.c4ccup.laugh.util.JwtUtil;

/**
 * トークンのインターセプタークラス
 *
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public TokenInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * リクエストの事前処理
     * 
     * @param request  HTTPリクエスト
     * @param response HTTPレスポンス
     * @param handler  ハンドラオブジェクト
     * @return 処理が継続可能な場合はtrue、それ以外の場合はfalse
     * @throws Exception 例外が発生した場合
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("Authorization");
        String tokenVal = "";
        // TODO:フロントの処理が実装されるまでトークンが渡ってこない場合trueを返す(tori)
        if (token == null)
            return true;

        String[] parts = token.split(" ");
        if (parts.length == 2 && parts[0].equals("Bearer")) {
            tokenVal = parts[1]; // トークンの値のみを格納
        }
        if (jwtUtil.isValidToken(tokenVal)) {
            return true;
        } else {
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            // TODO:フロントの処理が実装されるまでtrueを返すようにしておく(tori)
            return true;
        }
    }
}
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
        if (token != null && jwtUtil.validateToken(token)) {
            return true;
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }
    }
}
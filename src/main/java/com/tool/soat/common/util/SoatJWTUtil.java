package com.tool.soat.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2022/6/19 13:24
 * @File: SoatJWTUtil
 * @Software: IntelliJIDEA
 */

@Component
public class SoatJWTUtil {
    //过期时间
    private static Long expire = 604800L;

    // 秘钥
    private static String secret = "JWT_TOKEN_SHIRO";


    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String email) {
        //根据密码生成JWT效验器
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("email", email)
                .build();
        //效验TOKEN
        verifier.verify(token);
        return true;
    }
    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getEmail(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("email").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    /**
     * 获取用户id
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param email 用户名
     * @param userId
     * @return 加密的token
     */
    public static String sign(String email, Integer userId) {
        try {
            Date date = new Date(System.currentTimeMillis() + expire * 1000);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("email", email)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }

    }
    public static Long getExpire() {
        return expire;
    }

    public static void setExpire(Long expire) {
        SoatJWTUtil.expire = expire;
    }

    public static String getSecret() {
        return secret;
    }

    public static void setSecret(String secret) {
        SoatJWTUtil.secret = secret;
    }

}

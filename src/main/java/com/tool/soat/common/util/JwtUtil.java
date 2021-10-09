package com.tool.soat.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    public static final long EXPIRE_TIME = 30 * 60 * 1000;
    public static final String soat = "soat";
    public static final String AUTH_HEADER = "X-Authorization-With";


    //    创建一个token字符串
    public static String createToken(HashMap<String, String> map){
        if (map.isEmpty()){
            return "map集合为空";
        }
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(soat);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((key,value)->{
            builder.withClaim(key, value);
        });
        String sign = builder.withExpiresAt(date)
                .sign(algorithm);
        return sign;

    }

//    public static boolean verifyToken(String token,HashMap<String, String> map){
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(soat);
//            JWTVerifier verifier = JWT.require(algorithm).withClaim("map",map).build();
//
//
//            //验证 token
//            verifier.verify(token);
//            return true;
//        } catch (Exception exception) {
//            return false;
//        }
//    }


//    拿到payload，返回一个map集合
    public static Map<String, Claim> parseJWT(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaims();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}

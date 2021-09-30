package com.tool.soat.common;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SoatJWT {

    private static final String SOAT = "sail";

//    生成token
    public static String getToken(HashMap<String, String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,108000);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((key,value)->{
            builder.withClaim(key, value);
        });
        String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SOAT));
        return token;
    }


//    验证token
    public static DecodedJWT verifyToken(String token){
        HashMap<String, String> map = new HashMap<>();
        map.put("name1","1");
        map.put("name2","2");
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SOAT)).build().verify(getToken(map));
        return  decodedJWT;
    }

}

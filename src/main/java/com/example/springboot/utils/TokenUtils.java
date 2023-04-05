package com.example.springboot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Component
public class TokenUtils {
    //密匙
    private static final  String SECRET = "ma_ming_ming";
    //过期时间
    private static final long EXPIRATION = 3600L;
    @Resource
    private UserMapper userMapper;

    private static UserMapper staticUserMapper;

    @PostConstruct
    public void init() {
        staticUserMapper = userMapper;
    }
    public static String getToken(User user){
        Map<String,Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                .withHeader(map)
                .withAudience(String.valueOf(user.getId()))
                .withClaim("password",user.getPassword())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(SECRET));
    }
    public static User getUser(){
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String token = request.getHeader("token");
        if (Utils.isBlank(token)){
            log.error("解析token失败");
            return null;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (null!=jwt){
                String aud=jwt.getAudience().get(0);
                Integer userId = Integer.valueOf(aud);
                return staticUserMapper.selectById(userId);
            }

        } catch (Exception e) {
            log.error("解析token失败", e);
            return null;
        }
        return null;
    }
}
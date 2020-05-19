package com.sulin.apildempotence.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
public class TokenService {

    private final static String REDIS_TOKEN_KEY_PREFIX = "redis_token_";

    private final static String HEADER_NAME = "token";

    @Autowired
    RedisService redisService;

    /**
     * 创建token
     *
     * @return //
     */
    public synchronized String createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();

        token.append(REDIS_TOKEN_KEY_PREFIX).append(str);
        boolean success = redisService.setEx(token.toString(), token.toString(), 10000L);
        if (success)
            return token.toString();
        else
            return null;
    }

    public boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_NAME);
        if (Strings.isBlank(token)) {
            token = request.getParameter(HEADER_NAME);
            if (Strings.isBlank(token)) {
                throw new RuntimeException("token 不存在");
            }
        }
        //感觉这部很多余
        if (!redisService.exists(token)) {
            //重复提交
            throw new RuntimeException("重复提交");
        }
        //这里应该直接删除来判断 防止并发
        //redisService.redisTemplate.delete(token)
        //不能用select+delete 反正并发

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new RuntimeException("未知错误");
        }
        return true;
    }


}

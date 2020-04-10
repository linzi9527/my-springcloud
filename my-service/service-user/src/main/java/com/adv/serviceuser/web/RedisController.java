package com.adv.serviceuser.web;

import com.adv.serviceuser.conf.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:RedisController
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-23 上午12:02
 * @Version:1.0
 */
@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/redis/set/{key}/{value}")
    public String setRedis(@PathVariable String key,@PathVariable String value) {
        redisUtil.set(key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public String findRedis(@PathVariable String key) {
        return redisUtil.get(key);
    }
}
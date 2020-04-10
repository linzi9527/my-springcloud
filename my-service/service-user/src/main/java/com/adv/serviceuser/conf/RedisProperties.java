package com.adv.serviceuser.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName:RedisProperties
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-22 下午11:50
 * @Version:1.0
 */
@ConfigurationProperties(prefix = "spring.redis")
@Component
@Data
public class RedisProperties {
    //private int    expireSeconds;
    private String clusterNodes;
    private String password;
    private int    timeout;
    private int    maxIdle;
    private long   maxWait;
    private boolean isTestOnBorrow;


}

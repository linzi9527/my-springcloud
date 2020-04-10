package com.adv.data.mystreamprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableBinding(MyProviderMsgService.class)
@EnableEurekaClient
@SpringBootApplication
public class MyStreamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStreamProviderApplication.class, args);
    }

}

package com.adv.mystreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableBinding(ConsumerMsgService.class)
@EnableEurekaClient
@SpringBootApplication
public class MyStreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStreamConsumerApplication.class, args);
    }

}

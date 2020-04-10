package com.adv.myserviceproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MyServiceProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyServiceProducerApplication.class, args);
    }

}

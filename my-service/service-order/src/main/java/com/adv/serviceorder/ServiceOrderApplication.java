package com.adv.serviceorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;

@EnableEurekaClient
@FeignClient
@SpringBootApplication
public class ServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
        /*ConfigurableApplicationContext context= SpringApplication.run(ServiceOrderApplication.class, args);
        System.out.println("user="+context.getBean("user"));
        System.out.println("baseDao="+context.getBean("baseDao"));*/
    }

}

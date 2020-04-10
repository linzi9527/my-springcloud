package com.adv.serviceuser.service;

import com.adv.serviceuser.intercepter.FeignRequestIntercepter;
import com.adv.serviceuser.vo.Order;
import com.adv.serviceuser.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *开启Feign客户端，service-order是service-order微服务的serviceId
 */
@FeignClient(name = "service-order",configuration = FeignRequestIntercepter.class)
public interface OrderFeignService {

    //对应要调用的service-order微服务控制层请求方法
    @RequestMapping(value = "/msg")
    String getMsg(String msg);

    @RequestMapping(value = "/listInit/{s}")
    List<Order> setList(@PathVariable String s);

    //@PostMapping("/setUser")
    @GetMapping("/setUser")
    List<Order> setListByUser(@RequestBody User user);

    @RequestMapping(value = "/list")
    List<Order> getList();

    @RequestMapping(value = "/order/{id}")
    Order getOrderById(@PathVariable String id);

    @PostMapping("/saveOrder")
    boolean seveUser(@RequestBody Order o);
}

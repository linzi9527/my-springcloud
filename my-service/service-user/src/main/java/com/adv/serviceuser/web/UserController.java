package com.adv.serviceuser.web;

import com.adv.serviceuser.service.OrderFeignService;
import com.adv.serviceuser.vo.Order;
import com.adv.serviceuser.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:UserController
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-16 下午6:30
 * @Version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/v1.0")
public class UserController {

    @Autowired
    OrderFeignService orderFeignService;

    @RequestMapping("/getMsg")
    public String test(String s) {
        log.info("\n test后台数据:" + s);
        return orderFeignService.getMsg(s);
    }

    @RequestMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable String id){
        log.info("\n getOrderById后台数据:" + id);
        return orderFeignService.getOrderById(id);
    }

    @RequestMapping("/init/{s}")
    public List<Order> setList(@PathVariable String s){
        log.info("\n setList后台数据:" + s);
        return orderFeignService.setList(s);
    }
    @RequestMapping("/getList")
    public List<Order> getList(){
        log.info("\n getList后台");
        return orderFeignService.getList();
    }

    @RequestMapping("/setUser")
    public List<Order> setListByUser(User user) {
    //public List<Order> setListByUser(@RequestBody User user) {
        log.info("\n setListByUser后台:"+user);
        return orderFeignService.setListByUser(user);
    }
}

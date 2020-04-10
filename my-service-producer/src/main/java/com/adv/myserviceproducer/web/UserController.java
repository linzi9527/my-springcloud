package com.adv.myserviceproducer.web;

import com.adv.myserviceproducer.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class UserController {

    @RequestMapping("/info")
    public String test(String s){
        log.info("后台数据:"+s);
        return s;
    }

    @RequestMapping("/user")
    public User getUser(String s){
       User u= new User();
       u.setId("u"+System.currentTimeMillis());
       u.setName("中国机长");
       u.setAge(33);
       u.setAddr("四川航空");
        log.info("数据:"+u);
        return u;
    }
}

package com.adv.producer.web;

import com.adv.producer.vo.User;
import com.summaryday.framework.d.IBaseDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private IBaseDao baseDao;

    @RequestMapping("/info")
    public String test(String s) {
        log.info("后台数据:" + s);
        return s;
    }

    @RequestMapping("/user")
    public User getUser(String s) {
        User u = new User();
        u.setId("u" + System.currentTimeMillis());
        u.setUsername("中国机长service-producer-01");
        u.setAge(33);
        u.setAddr("四川航空-"+s);
        log.info("数据:" + u);
        return u;
    }


    @PostMapping("/saveUser")
    public boolean saveUser(@PathVariable User user){
        boolean flag=false;
        try {
           flag= baseDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }



}

package com.adv.producer.conf;

import com.adv.producer.vo.User;
import com.summaryday.framework.d.IBaseDao;
import com.summaryday.framework.d.JODBBaseDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:ConfBeans
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-19 下午3:56
 * @Version:1.0
 */

@Configuration
public class ConfBeans {

    @Bean(name = "baseDao")
    public IBaseDao getBaseDao(){
       return new JODBBaseDaoImpl();
    }



    @Bean(name = "user")
    public User getUser(){
        User user=new User();
        user.setId(""+System.currentTimeMillis());
        user.setUsername("中国机长");
        user.setAge(35);
        user.setAddr("四川航空");
        return user;
    }

}

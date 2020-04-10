package com.adv.serviceorder.conf;

import com.adv.serviceorder.vo.User;
import com.summaryday.framework.d.BaseDaoImpl;
import com.summaryday.framework.db.SpringBeanHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:ConfBeans
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-18 下午5:00
 * @Version:1.0
 */
@Slf4j
@Configuration
public class ConfBeans {

    @Bean(name = "SpringBeanHelper")
    public SpringBeanHelper getSpringBeanHelper(){
        log.info("============SpringBeanHelper=============");
        return new SpringBeanHelper();
    }

    @Bean(name = "baseDao")
    public BaseDaoImpl getBaseDaoImpl(){
        log.info("==================IBaseDao====================");
        return new BaseDaoImpl();
    }


}

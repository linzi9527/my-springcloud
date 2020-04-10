package com.adv.serviceuser.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName:FeignRequestIntercepter
 * @Description:TODO
 * 实现RequestInterceptor，用于设置feign全局请求模板
 *
 * 在实现项目的时候发现，微服务使用feign相互之间调用时，存在session丢失的问题。
 * 例如，使用Feign调用某个远程API，这个远程API需要传递一个用户信息，
 * 我们可以把cookie里面的session信息放到Header里面，这个Header是动态的，
 * 跟你的HttpRequest相关，我们选择编写一个拦截器来实现Header的传递，
 * 也就是需要实现RequestInterceptor接口。
 * ————————————————
 * 经过测试，上面的解决方案可以正常的使用；
 * 但是，当引入Hystrix熔断策略时，出现了一个新的问题；(意味熔断器如果设置false是可以使用)
 * @Author:nano
 * @Date:20-2-18 下午12:22
 * @Version:1.0
 */

@Slf4j
@Configuration
@EnableFeignClients
public class FeignRequestIntercepter implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //通过RequestContextHolder获取本地请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        //获取本地线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        log.info("\n session-id: "+request.getSession().getId());
        //给请求模板附加本地线程头部信息，主要是cookie信息
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    requestTemplate.header(name, value);
                    log.info("\n 本地线程头部信息:name="+value);
                }
            }
        }

    }
}

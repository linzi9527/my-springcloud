package com.adv.data.mystreamprovider.service;

import com.adv.data.mystreamprovider.interfaces.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @ClassName:MyProviderMsgService
 * @Description:TODO
 * 首先自定义一个接口interface MySource这样还不行，
 * 还必须改造springcloud-stream消息发送端的SendService这个类
 * @Author:nano
 * @Date:20-2-19 下午9:05
 * @Version:1.0
 */

@EnableBinding(MySource.class)
public class MyProviderMsgService {
    @Autowired
    private MySource mySource;

    public void sendMsg(String msg){
        mySource.myOutput().send(MessageBuilder.withPayload(msg).build());
    }
}

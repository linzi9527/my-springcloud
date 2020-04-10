package com.adv.data.mystreamprovider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @ClassName:ProviderMsgService
 * @Description:TODO
 * Stream给我们提供的默认Source
 * 这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，
 * 可以看到output和input,这和配置文件中的output，input对应的
 * 声明发送消息的接口
 * @Author:nano
 * @Date:20-2-19 下午7:48
 * @Version:1.0
 */

//@EnableBinding(Source.class)
public class ProviderMsgService {

   /* @Autowired
    private Source source;

    public void sendMsg(String msg){
        source.output().send(MessageBuilder.withPayload(msg).build());
    }*/
}

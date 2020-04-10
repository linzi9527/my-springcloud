package com.adv.mystreamconsumer.service;

import com.adv.mystreamconsumer.interfaces.MySink;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @ClassName:ConsumerMsgService
 * @Description:TODO
 * 消息接受端，stream给我们提供了Sink,Sink源码里面是绑定input的，要跟我们配置文件的imput关联的
 * @Author:nano
 * @Date:20-2-19 下午8:47
 * @Version:1.0
 */
@Slf4j
//@EnableBinding(Sink.class)
@EnableBinding(MySink.class)
public class ConsumerMsgService {

    private static int count=0;
    //@StreamListener(Sink.INPUT)
    @StreamListener(MySink.TopicName)
    public void recieve(byte[] payload){

        String jsonData=new String(payload);
        //System.out.println("\n\n读取消息payload:"+jsonData+"\n");
        JSONObject obj=JSONObject.parseObject(jsonData);
        count++;
        //log.info("\n ==============================================\n obj="+obj);
        log.info("\n ==========================(count="+count+")====================\n userId="+obj.getString("userId")+
                 "\n time="+obj.getString("time")+
                 "\n userName="+obj.getString("userName")+
                 "\n say="+obj.getString("say"));
    }
}

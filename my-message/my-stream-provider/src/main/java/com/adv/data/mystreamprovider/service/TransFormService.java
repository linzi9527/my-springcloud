package com.adv.data.mystreamprovider.service;

/**
 * @ClassName:TransFormService
 * @Description:TODO
 * springcloud-stream还给我们提供了一个Processor接口，
 * 用于进行消息处理后再进行发送出去，相当于一个消息中转站
 * @Author:nano
 * @Date:20-2-19 下午9:17
 * @Version:1.0
 */

//@EnableBinding(Processor.class)
public class TransFormService {
/*
    @ServiceActivator(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
    public Object transfrom(Object payload){
        System.out.println("消息中转站："+payload);
        return  payload;
    }*/
}

package com.adv.mystreamconsumer.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName:MySink
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-20 下午10:48
 * @Version:1.0
 */


public interface MySink {

    String TopicName="example-topic";

    @Input(TopicName)
    SubscribableChannel myInput();
}

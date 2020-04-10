package com.adv.data.mystreamprovider.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @ClassName:MySource
 * @Description:TODO
 * Stream给我们提供的默认Source，Sink，接下来我们要自己进行自定义，
 * 这种方式在工作中还是用的比较多的，因为我们要往不同的消息通道发消息
 * @Author:nano
 * @Date:20-2-19 下午9:02
 * @Version:1.0
 */
public interface MySource {

    String TopicName="example-topic";

    @Output(TopicName)
    MessageChannel myOutput();
}

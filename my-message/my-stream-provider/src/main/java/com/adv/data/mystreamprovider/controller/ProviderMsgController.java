package com.adv.data.mystreamprovider.controller;

import com.adv.data.mystreamprovider.service.MyProviderMsgService;
import com.adv.data.mystreamprovider.service.ProviderMsgService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName:cc
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-19 下午7:56
 * @Version:1.0
 */
@Slf4j
@RestController
public class ProviderMsgController {

    private static String flag="";
    private static int count=0;

    @Autowired
    //private ProviderMsgService providerMsgService;
    private MyProviderMsgService  providerMsgService;

    @RequestMapping("/send/{msg}")
    public String send(@PathVariable String msg){
       flag= msg.equals("quit")?"quit":"ok";
        while (!flag.equals("quit")) {
            JSONObject obj = new JSONObject();
            obj.put("userId", "u-"+ UUID.randomUUID().toString().replace("-",""));
            obj.put("userName", "中国机长");
            obj.put("time", LocalDate.now().toString());
            obj.put("say", msg);
            //msg = "中国机长say:" + obj.toString() + "," + LocalDate.now();
            providerMsgService.sendMsg(obj.toString());
            count++;
            log.info("\n生成消息(count="+count+"):"+obj.toString()+"\n");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
            }
        }
        return "success";
    }

}

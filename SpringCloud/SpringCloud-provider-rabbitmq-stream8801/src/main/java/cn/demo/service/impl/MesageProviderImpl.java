package cn.demo.service.impl;

import cn.demo.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Classname MesageProviderImpl
 * @Description TODO
 * @Date 2020/7/27 18:15
 * @Created by XJC·AW
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MesageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //属于消息发送管道

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        log.info("s:>>>>>>>>" + s);
        return null;
    }
}

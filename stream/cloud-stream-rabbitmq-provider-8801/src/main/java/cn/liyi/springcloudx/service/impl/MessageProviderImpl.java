package cn.liyi.springcloudx.service.impl;

import cn.liyi.springcloudx.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


/**
 * @Classname MessageProviderImpl
 * @Description TODO
 * @Date 2020/7/17 16:39
 * @Created by liyi
 */
@EnableBinding(Source.class) //消息提供者
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    @Override
    public Boolean send(String msg) {
        return output.send(MessageBuilder.withPayload(msg).build());
    }
}

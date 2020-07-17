package cn.liyi.springcloudx.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Classname ReceiveMessageListener
 * @Description TODO
 * @Date 2020/7/17 17:15
 * @Created by liyi
 */
@Component
@EnableBinding(Sink.class) //消息提供者
@Slf4j
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.warn("port:" + port + "接收到消息 :" + message.getPayload());
    }

}

package cn.liyi.springcloudx.service;

/**
 * @Classname IMessageProvider
 * @Description TODO
 * @Date 2020/7/17 16:38
 * @Created by liyi
 */
public interface IMessageProvider {

    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    Boolean send(String msg);

}

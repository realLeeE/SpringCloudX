package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname MsgController
 * @Description TODO
 * @Date 2020/7/17 16:47
 * @Created by liyi
 */
@RestController
public class MsgController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping(value = "/stream/provider/send/{msg}")
    public R<Boolean> sendMsg(@PathVariable(value = "msg") String msg) {
        return new R<>(messageProvider.send(msg + UUID.randomUUID().toString()));
    }


}

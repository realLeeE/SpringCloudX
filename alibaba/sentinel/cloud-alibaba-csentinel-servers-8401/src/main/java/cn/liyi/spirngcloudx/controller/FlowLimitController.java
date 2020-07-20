package cn.liyi.spirngcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SentinelContrller
 * @Description TODO
 * @Date 2020/7/20 16:31
 * @Created by liyi
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    private R<String> testA() {
        log.info("aaaaaaaaaaaaaaaa");
        return new R<>("AAAA");
    }

    @GetMapping(value = "/testB")
    private R<String> testB() {
        log.info("bbbbbbbbbbbbbbbbbbbb");
        return new R<>("BBBB");
    }

}
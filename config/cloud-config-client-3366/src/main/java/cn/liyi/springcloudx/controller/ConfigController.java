package cn.liyi.springcloudx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ConfigController
 * @Description TODO
 * @Date 2020/7/17 13:48
 * @Created by liyi
 */
@RestController
@RefreshScope //刷新配置注解 配置之后需要手动刷新配置 curl -X POST http://localhost:3344/actuator/refresh
public class ConfigController {

    @Value("${username}")
    private String configInfo;

    @GetMapping(value = "/configInfo")
    public String getConfig() {
        return configInfo;
    }

}

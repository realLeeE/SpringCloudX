package cn.liyi.spirngcloudx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ConfigClientController
 * @Description TODO
 * @Date 2020/7/18 15:26
 * @Created by liyi
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${username}")
    private String username;

    @GetMapping(value = "/config/name")
    public String getConfigInfo() {
        return username;
    }

}

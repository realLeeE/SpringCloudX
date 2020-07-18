package cn.liyi.spirngcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PaymentProviderController
 * @Description TODO
 * @Date 2020/7/18 12:16
 * @Created by liyi
 */
@RestController
public class PaymentProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/{id}")
    public R<String> echo(@PathVariable(value = "id") String id) {
        return new R<>("hello word nacos,port: " + port + "  id:" + id);
    }

}

package cn.liyi.spirngcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderNacosController
 * @Description TODO
 * @Date 2020/7/18 14:27
 * @Created by liyi
 */
@RestController
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public R<String> paymentInfo(@PathVariable("id") Long id) {
        return this.restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, R.class);
    }

}

package cn.liyi.spirngcloudx.controller;

import cn.liyi.spirngcloudx.service.PaymentFeignService;
import cn.liyi.springcloudx.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderNacosController
 * @Description TODO
 * @Date 2020/7/18 14:27
 * @Created by liyi
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer")
    public R<String> paymentInfo(Long id) {
        log.info(Thread.currentThread().getName()+"   /consumer");
        return paymentFeignService.echo(id.toString());
    }

}

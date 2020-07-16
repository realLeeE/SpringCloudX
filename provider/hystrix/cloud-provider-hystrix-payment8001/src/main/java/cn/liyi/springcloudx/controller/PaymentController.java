package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/7/9 10:06
 * @Created by liyi
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment/hystrix")
public class PaymentController {

    @Value("${server.port}")
    private String servicePort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "ok/{id}")
    public R<String> ok(@PathVariable("id") Long id) {
        return new R<>(paymentService.paymentInfo_OK(id));
    }

    @GetMapping(value = "timeout/{id}")
    public R<String> timeOut(@PathVariable("id") Long id) {
        String r = paymentService.paymentInfo_TimeOut(id);
        log.info(r);
        return new R<>(r);
    }

}

package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/7/9 11:12
 * @Created by liyi
 */
@RestController
@Slf4j
public class OrderController {


    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/order/payment")
    public R<Payment> get(Long id) {
        return paymentFeignService.get(id);
    }

    @GetMapping(value = "/consumer/order/timeout")
    public R<String> timeOut() {
        return new R<>(paymentFeignService.timeOut());
    }
}

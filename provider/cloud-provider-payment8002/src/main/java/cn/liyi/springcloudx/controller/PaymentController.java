package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/7/9 10:06
 * @Created by liyi
 */
@RestController
@Slf4j
@RequestMapping(value = "/pay/payment")
public class PaymentController {

    @Value("${server.port}")
    private String servicePort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<Boolean> create(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);
        log.info("/pay/payment/create :{}", payment);
        return new R<Boolean>().setMsg("port:" + servicePort);
    }

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public R<Payment> get(Long id) {
        Payment byId = paymentService.getById(id);
        return new R<Payment>(byId).setMsg("port:" + servicePort);
    }

    @GetMapping(value = "lb")
    public String getLB(){
        return servicePort;
    }

    @GetMapping(value = "/timeout")
    public String timeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }
}

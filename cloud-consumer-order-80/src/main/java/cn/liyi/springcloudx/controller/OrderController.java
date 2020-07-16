package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/7/9 11:12
 * @Created by liyi
 */
@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public R<Boolean> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/payment/create", payment, R.class);
    }

    @GetMapping(value = "/consumer/pay/payment")
    public R<Payment> get(Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/payment?id=" + id, R.class);
    }

    @GetMapping(value = "/consumer/pay/payment/getEntity")
    public R<Payment> get2(Long id) {
        ResponseEntity<R> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/pay/payment?id=" + id, R.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new R<>();
        }
    }


}

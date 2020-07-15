package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    @Autowired
    private LoadBalancer LoadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/lb")
    public String getLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (null == instances || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = LoadBalancer.instance(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/pay/payment/lb", String.class);
    }

}

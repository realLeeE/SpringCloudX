package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(ele -> System.err.println("services:" + ele));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ele : instances) {
            System.err.println("instances:" + ele.getUri() + "---" + ele.getHost() + "---" + ele.getPort() + "---");
            Map<String, String> metadata = ele.getMetadata();
            for (Map.Entry<String, String> stringStringEntry : metadata.entrySet()) {
                System.err.println("KEY:" + stringStringEntry.getKey() + " VALUE:" + stringStringEntry.getValue());
            }
        }
        int order = discoveryClient.getOrder();
        System.err.println(order);
        return new R<Void>();
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

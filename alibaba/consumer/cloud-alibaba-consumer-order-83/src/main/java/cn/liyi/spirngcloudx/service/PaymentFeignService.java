package cn.liyi.spirngcloudx.service;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentFeignService
 * @Description TODO
 * @Date 2020/7/21 14:11
 * @Created by liyi
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFeignServiceFallback.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/nacos/{id}")
    R<String> echo(@PathVariable(value = "id") String id);

    @GetMapping(value = "/payment/get/{id}")
    R<Payment> get(@PathVariable(value = "id") Long id);

}

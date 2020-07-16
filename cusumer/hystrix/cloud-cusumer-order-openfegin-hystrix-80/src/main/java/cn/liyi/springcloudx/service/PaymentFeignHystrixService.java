package cn.liyi.springcloudx.service;

import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentFeignService
 * @Description TODO
 * @Date 2020/7/15 17:42
 * @Created by liyi
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentFeignHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<String> ok(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<String> timeOut(@PathVariable("id") Long id);

}



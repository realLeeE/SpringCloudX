package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/7/9 11:12
 * @Created by liyi
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderController {

    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping(value = "/consumer/order/ok/{id}")
    public R<String> get(@PathVariable(value = "id") Long id) {
        return paymentFeignHystrixService.ok(id);
    }

    @GetMapping(value = "/consumer/order/timeout/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"),
//    })
    public R<String> timeOut(@PathVariable(value = "id") Long id) {
        return paymentFeignHystrixService.timeOut(id);
    }

    public R<String> paymentInfo_TimeOut_Handler(Long id) {
        return new R<>("线程池： " + Thread.currentThread().getName() + " 80paymentInfo_TimeOut_Handler,id: " + id + "失败 o(╥﹏╥)o");
    }

    public R<String> payment_global_fallbackMethod() {
        return new R<>("线程池： " + Thread.currentThread().getName() + " 80payment_global_fallbackMethod,统一fallback 失败 o(╥﹏╥)o");
    }

}

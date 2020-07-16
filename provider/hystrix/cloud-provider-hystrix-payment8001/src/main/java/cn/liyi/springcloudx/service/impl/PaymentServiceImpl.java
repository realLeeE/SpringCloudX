package cn.liyi.springcloudx.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.liyi.springcloudx.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentServiceImpl
 * @Description PaymentServiceImpl
 * @Date 2020/7/9 10:03
 * @Created by liyi
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Long id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
    })
    public String paymentInfo_TimeOut(Long id) {
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 996 / 0;
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t   耗时" + timeout + "秒";
    }

    public String paymentInfo_TimeOut_Handler(Long id) {
        return "线程池： " + Thread.currentThread().getName() + " 8001paymentInfo_TimeOut_Handler,id: " + id + "失败 o(╥﹏╥)o";
    }

    //========== 熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("******-------  ID 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Long id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}

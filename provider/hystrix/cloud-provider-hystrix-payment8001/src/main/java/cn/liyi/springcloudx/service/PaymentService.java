package cn.liyi.springcloudx.service;


/**
 * @Classname PaymentService
 * @Description PaymentService
 * @Date 2020/7/9 10:02
 * @Created by liyi
 */
public interface PaymentService {

    String paymentInfo_OK(Long id);

    String paymentInfo_TimeOut(Long id);

    String paymentCircuitBreaker(Long id);
}

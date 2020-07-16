package cn.liyi.springcloudx.service.impl;

import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/7/16 11:53
 * @Created by liyi
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService {

    @Override
    public R<String> ok(Long id) {
        return new R<>("----PaymentFallbackService fallback ok,o(╥﹏╥)o");
    }

    @Override
    public R<String> timeOut(Long id) {
        return new R<>("----PaymentFallbackService fallback timeOut,o(╥﹏╥)o");
    }
}

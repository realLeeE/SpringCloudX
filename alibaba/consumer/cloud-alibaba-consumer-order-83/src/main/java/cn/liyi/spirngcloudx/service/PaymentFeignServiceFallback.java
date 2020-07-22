package cn.liyi.spirngcloudx.service;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFeignServiceFallback
 * @Description TODO
 * @Date 2020/7/22 14:46
 * @Created by liyi
 */
@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {

    @Override
    public R<String> echo(String id) {
        return new R<>(454, "echo 兜底");
    }

    @Override
    public R<Payment> get(Long id) {
        return new R<>(455, "echo get");
    }
}

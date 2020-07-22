package cn.liyi.spirngcloudx.controller;

import cn.liyi.spirngcloudx.mapper.PaymentMapper;
import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PaymentProviderController
 * @Description TODO
 * @Date 2020/7/18 12:16
 * @Created by liyi
 */
@RestController
@Slf4j
public class PaymentProviderController {

    @Autowired
    private PaymentMapper paymentMapper;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/{id}")
    public R<String> echo(@PathVariable(value = "id") String id) {
        return new R<>("hello word nacos,port: " + port + "  id:" + id);
    }

    @GetMapping(value = "/payment/get/{id}")
    public R<Payment> get(@PathVariable(value = "id") Long id) {
        int i = 10 / 0;
        log.info("port: {}   /payment/get/{id}  " + id, port);
        Payment payment = paymentMapper.selectOne(Wrappers.<Payment>lambdaQuery().eq(Payment::getId, id).last(" limit 1"));
        return new R<>(payment);
    }

}

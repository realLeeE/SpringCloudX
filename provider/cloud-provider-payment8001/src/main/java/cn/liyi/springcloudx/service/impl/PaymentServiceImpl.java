package cn.liyi.springcloudx.service.impl;

import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.mapper.PaymentMapper;
import cn.liyi.springcloudx.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname PaymentServiceImpl
 * @Description PaymentServiceImpl
 * @Date 2020/7/9 10:03
 * @Created by liyi
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

}

package cn.liyi.spirngcloudx.controller;

import cn.liyi.spirngcloudx.service.PaymentFeignService;
import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderNacosController
 * @Description TODO
 * @Date 2020/7/18 14:27
 * @Created by liyi
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer")
    public R<String> paymentInfo(Long id) {
        log.info(Thread.currentThread().getName() + "   /consumer");
        return paymentFeignService.echo(id.toString());
    }

    @GetMapping(value = "/consumer/get/{id}")
//    @SentinelResource(value = "getFallback")
//    @SentinelResource(value = "getFallback", fallback = "fallbackHandler")
//    @SentinelResource(value = "getFallback", blockHandler = "blockHandler")
//    @SentinelResource(value = "getFallback", blockHandler = "blockHandler"
//            , fallback = "fallbackHandler", exceptionsToIgnore = NullPointerException.class)
    public R<Payment> get(@PathVariable(value = "id") Long id) {
        R<Payment> result = paymentFeignService.get(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }
    public R<?> fallbackHandler(Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new R<>(444, "兜底异常handlerFallback,exception内容  " + e.getMessage(), payment);
    }
    public R<?> blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new R<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }

}

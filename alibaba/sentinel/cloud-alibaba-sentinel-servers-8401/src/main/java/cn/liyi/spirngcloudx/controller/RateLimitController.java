package cn.liyi.spirngcloudx.controller;

import cn.liyi.spirngcloudx.config.CustomerBlockHandler;
import cn.liyi.springcloudx.entity.Payment;
import cn.liyi.springcloudx.entity.R;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-25 15:04
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public R<?> byResource() {
        return new R<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public R<?> handleException(BlockException exception) {
        return new R<>(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public R<?> byUrl() {
        return new R<>(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public R<?> customerBlockHandler() {
        return new R<>(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}
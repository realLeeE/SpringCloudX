package cn.liyi.spirngcloudx.controller;

import cn.liyi.springcloudx.entity.R;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Classname SentinelContrller
 * @Description TODO
 * @Date 2020/7/20 16:31
 * @Created by liyi
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/hello/abc")
    private R<String> testA() {
        log.info("aaaaaaaaaaaaaaaa");
        return new R<>("AAAA");
    }

    @GetMapping(value = "/hello/def")
    private R<String> testB() {
        String resourceName = "/hello/def";
        // 这里不使用try-with-resources是因为Tracer.trace会统计不上异常
        Entry entry = null;
        try {
            // 定义一个sentinel保护的资源，名称为test-sentinel-api
            entry = SphU.entry(resourceName);
            // 标识对test-sentinel-api调用来源为test-origin（用于流控规则中“针对来源”的配置）
            ContextUtil.enter(resourceName, "test-origin");
            // 模拟执行被保护的业务逻辑耗时
            Thread.sleep(100);
            log.info("bbbbbbbbbbbbbbbbbbbb");
            return new R<>("BBBB");
        } catch (BlockException e) {
            // 如果被保护的资源被限流或者降级了，就会抛出BlockException
            log.warn("资源被限流或降级了", e);
            return new R<>("资源被限流或降级了");
        } catch (InterruptedException e) {
            // 对业务异常进行统计
            Tracer.trace(e);
            return new R<>("发生InterruptedException");
        } finally {
            if (entry != null) {
                entry.exit();
            }
            ContextUtil.exit();
        }

    }


    @GetMapping("/testD")
    public String testD()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

//        log.info("testD 异常比例");
//        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2)
    {
//        int age = 10/0;
        return "------testHotKey";
    }
    public String deal_testHotKey (String p1, String p2, BlockException exception)
    {
        return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

}

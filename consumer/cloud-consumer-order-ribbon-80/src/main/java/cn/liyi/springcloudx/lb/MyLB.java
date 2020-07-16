package cn.liyi.springcloudx.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname MyLB
 * @Description TODO
 * @Date 2020/7/15 16:53
 * @Created by liyi
 */
@Configuration
@Slf4j
public class MyLB implements LoadBalancer {

    /**
     * 原子类
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("------------- next:{}", next);
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {
        // 取第几个服务
        int index = getAndIncrement() % serviceInstance.size();
        return serviceInstance.get(index);
    }


}

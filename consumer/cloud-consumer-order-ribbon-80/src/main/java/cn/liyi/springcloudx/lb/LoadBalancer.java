package cn.liyi.springcloudx.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalancer
 * @Description TODO
 * @Date 2020/7/15 16:51
 * @Created by liyi
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstance);

}

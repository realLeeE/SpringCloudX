package cn.liyi.spirngcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname OrderNacosMain83
 * @Description TODO
 * @Date 2020/7/18 12:08
 * @Created by liyi
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderConsumerMain83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain83.class, args);
    }

}

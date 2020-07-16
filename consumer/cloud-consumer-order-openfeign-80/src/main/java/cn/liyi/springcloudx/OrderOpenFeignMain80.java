package cn.liyi.springcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname OrderOpenFeignMain80
 * @Description TODO
 * @Date 2020/7/9 11:01
 * @Created by liyi
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderOpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain80.class, args);
    }

}

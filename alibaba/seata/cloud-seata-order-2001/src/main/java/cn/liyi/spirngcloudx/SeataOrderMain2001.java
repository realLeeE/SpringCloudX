package cn.liyi.spirngcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataOrderMain2001
 * @Description TODO
 * @Date 2020/7/23 10:14
 * @Created by liyi
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "cn.liyi.springcloudx.api")
@EnableDiscoveryClient
public class SeataOrderMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001.class, args);
    }

}

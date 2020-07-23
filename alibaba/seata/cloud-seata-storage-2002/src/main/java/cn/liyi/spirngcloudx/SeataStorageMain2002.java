package cn.liyi.spirngcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataStorageMain2002
 * @Description TODO
 * @Date 2020/7/23 14:48
 * @Created by liyi
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "cn.liyi.springcloudx.api")
@EnableDiscoveryClient
public class SeataStorageMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002.class, args);
    }
}

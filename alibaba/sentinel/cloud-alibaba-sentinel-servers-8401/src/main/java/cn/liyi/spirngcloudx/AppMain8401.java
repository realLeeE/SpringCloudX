package cn.liyi.spirngcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname NacosSentinelMain8401
 * @Description TODO
 * @Date 2020/7/20 16:24
 * @Created by liyi
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain8401 {

    public static void main(String[] args) {
        SpringApplication.run(AppMain8401.class, args);
    }

}

package cn.liyi.spirngcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname AlibabaPayment9002
 * @Description TODO
 * @Date 2020/7/18 12:08
 * @Created by liyi
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9002 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9002.class, args);
    }

}

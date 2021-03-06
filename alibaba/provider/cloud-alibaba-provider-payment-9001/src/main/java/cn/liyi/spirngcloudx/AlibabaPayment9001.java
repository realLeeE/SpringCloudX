package cn.liyi.spirngcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname AlibabaPayment9001
 * @Description TODO
 * @Date 2020/7/18 12:08
 * @Created by liyi
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9001 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9001.class, args);
    }

}

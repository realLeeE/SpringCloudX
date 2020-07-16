package cn.liyi.springcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname OrderRibbonMain80
 * @Description TODO
 * @Date 2020/7/9 11:01
 * @Created by liyi
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClients(
//        @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
//)
public class OrderRibbonMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderRibbonMain80.class, args);
    }

}

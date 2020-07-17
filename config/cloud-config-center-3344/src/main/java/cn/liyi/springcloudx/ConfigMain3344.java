package cn.liyi.springcloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname ConfigMain3344
 * @Description TODO
 * @Date 2020/7/17 11:52
 * @Created by liyi
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class, args);
    }

}

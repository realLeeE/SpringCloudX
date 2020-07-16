package cn.liyi.springcloudx.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Classname FeignConfig
 * @Description TODO
 * @Date 2020/7/16 9:24
 * @Created by liyi
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}

package cn.liyi.spirngcloudx.config;

import org.springframework.web.client.RestTemplate;

/**
 * @Classname RestTemplateConfig
 * @Description TODO
 * @Date 2020/7/18 14:25
 * @Created by liyi
 */
//@Configuration
public class RestTemplateConfig {

//    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

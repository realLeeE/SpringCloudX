package cn.liyi.springcloudx.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GateWayConfig
 * @Description TODO
 * @Date 2020/7/17 9:16
 * @Created by liyi
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        // 有坑,path 前面必须加上斜杠 "/"
        return builder
                .routes()
                .route("route_1", ele -> ele.path("/guonei").uri("https://news.baidu.com/guonei"))
                .route("route_2", ele -> ele.path("/guoji").uri("https://news.baidu.com/guoji"))
                .route("route_3", ele -> ele.path("/sports").uri("https://news.baidu.com/sports"))
                .build();
    }

}

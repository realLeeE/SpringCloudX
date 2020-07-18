# 学习 springcloud 路程实践 

> https://www.bilibili.com/video/BV18E411x7eT?p=105

## spirngcloud

1. RestTemplate支持服务调用, 需要配置@LoadBalanced, 原理未知

2. eureka 自我保护机制 eurekaClient DOWN之后 ，不会立刻清理

3. 新版eureka自带ribbon  

4. fallback服务降级 break服务熔断 flowlimit服务限流

5. gateway 概念: route  predicate filter

6. bootstrap.yml 优先级高于 application.yml

7. @RefreshScope 配置之后需要手动刷新配置 

   ```
   curl -X POST http://localhost:3355/actuator/refresh
   ```

8. bus 刷新center配置中心: 

   ```
   curl -X POST http://localhost:3344/actuator/bus-refresh
   ```

9. bus 定点刷新某一个配置: 

   ```
   curl -X POST http://localhost:{配置中心端口}/actuator/bus-refresh/{destination}
   ```

## spirngcloud-alibaba

1. 由于 Spring Boot 1 和 Spring Boot 2 在 Actuator 模块的接口和注解有很大的变更，且 spring-cloud-commons 从 1.x.x 版本升级到 2.0.0 版本也有较大的变更，因此我们采取跟 SpringBoot 版本号一致的版本:

    ```
    1.5.x 版本适用于 Spring Boot 1.5.x
    2.0.x 版本适用于 Spring Boot 2.0.x
    2.1.x 版本适用于 Spring Boot 2.1.x
    2.2.x 版本适用于 Spring Boot 2.2.x
    ```

2. nacos整合了ribbon 自带负载均衡(策略为轮询)

3. nacos支持AP和CP模式切换

4. nacos config 

    ```
    ${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
    nacos-config-client-dev.yml
    ```
5. nacos config 自带配置刷新功能


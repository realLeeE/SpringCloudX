学习 springcloud 路程实践 

https://www.bilibili.com/video/BV18E411x7eT?p=94

1. RestTemplate支持服务调用, 需要配置@LoadBalanced, 原理未知
2. eureka 自我保护机制 eurekaClient DOWN之后 ，不会立刻清理
3. 新版eureka自带ribbon  
4. fallback服务降级 break服务熔断 flowlimit服务限流
5. gateway 概念: route  predicate filter
6. bootstrap.yml 优先级高于 application.yml
7. @RefreshScope 配置之后需要手动刷新配置 curl -X POST http://localhost:3355/actuator/refresh
8. bus 刷新center配置中心: curl -X POST http://localhost:3344/actuator/bus-refresh
9. bus 定点刷新某一个配置: curl -X POST http://localhost:{配置中心端口}/actuator/bus-refresh/{destination}
学习 springcloud 路程实践 

https://www.bilibili.com/video/BV18E411x7eT?p=65

1. RestTemplate支持服务调用, 需要配置@LoadBalanced, 原理未知
2. eureka 自我保护机制 eurekaClient DOWN之后 ，不会立刻清理
3. 新版eureka自带ribbon  
4. fallback服务降级 break服务熔断 flowlimit服务限流
5. gateway 概念: route  predicate filter
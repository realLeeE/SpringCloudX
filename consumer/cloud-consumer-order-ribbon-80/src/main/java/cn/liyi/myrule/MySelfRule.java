package cn.liyi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MySelfRule
 * @Description TODO
 * @Date 2020/7/15 16:31
 * @Created by liyi
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 随机
        return new RandomRule();
    }

}

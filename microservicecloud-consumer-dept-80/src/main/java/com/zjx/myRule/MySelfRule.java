package com.zjx.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Alex
 * @Desc <p>自定义ribbon策略，但是不能放在@ComponentScan包的下面</p>
 * @Date 2018/9/1 13:07
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
//        return new RandomRule();
        return  new RandomRule_HQ();
    }
}

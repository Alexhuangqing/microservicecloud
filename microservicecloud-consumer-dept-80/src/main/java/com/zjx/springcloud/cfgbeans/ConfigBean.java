package com.zjx.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Alex
 * @Desc <p>配置类，类似application.xml</p>
 * @Date 2018/8/26 16:07
 */
@Configuration
public class ConfigBean {

    /*rest服务访问模板，ribbon默认的负载均衡为轮询*/
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*选择ribbon中默认的七大策略之一*/
   /* @Bean
    public IRule iRule(){
        return new RandomRule();
    }*/


}

package com.zjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author Alex
 * @Desc <p></p>
 * @Date 2018/8/26 16:19
 */
@SpringBootApplication
//从eurakaServer端拉取注册的provider
@EnableEurekaClient
//可在客户端开启  服务熔断      服务降级处理（服务降级是在客户端编码，另还需配置yml文件）
@EnableFeignClients
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class,args);
    }
}

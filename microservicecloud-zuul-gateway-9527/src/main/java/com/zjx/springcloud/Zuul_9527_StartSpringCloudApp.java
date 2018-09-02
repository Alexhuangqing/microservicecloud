package com.zjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author Alex
 * @Desc <p></p>
 * @Date 2018/9/2 17:49
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {
    public static void main(String[] args) { SpringApplication.run(Zuul_9527_StartSpringCloudApp.class,args); }
}

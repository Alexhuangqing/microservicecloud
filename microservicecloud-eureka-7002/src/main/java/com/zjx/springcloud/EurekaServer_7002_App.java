package com.zjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //注册eureka服务端
public class EurekaServer_7002_App {
    public static void main(String[] args) {

        SpringApplication.run(EurekaServer_7002_App.class, args);
    }
}

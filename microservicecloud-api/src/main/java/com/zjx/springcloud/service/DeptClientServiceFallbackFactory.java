package com.zjx.springcloud.service;

import com.zjx.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Alex
 * @Desc <p>注册客户端服务降级处理组件</p>
 * @Date 2018/9/2 13:12
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) { return new Dept().setDeptno(id).setDname("provider is closed ,then open 客户端服务降级处理")
                        .setDb_source("no source from mysql db");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}

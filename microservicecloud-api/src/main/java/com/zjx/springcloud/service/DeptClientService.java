package com.zjx.springcloud.service;

import com.zjx.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author Alex
 * @Desc
 * <p>
 *      1.Feign通过接口的方法调用Rest服务(之前是Ribbon+RestTemplate),
 *      该请求发送给Eureka服务器(http://MICROSERVICECLOUD-DEPT/dept/list),
 *      通过Feign直接找到服务接口,由于在进行服务调用的时候融合了Ribbon技术,所以也支持负载均衡作用.
 *
 *      **感觉就是对“Ribbon+RestTemplate”访问方式，在客户端的再一次封装
 *      2.当访问服务端，失败失败，去客户端找到fallbackFactory标记的客户端处理“DeptClientService”实现
 * </p>
 * @Date 2018/9/2 8:37
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);
}

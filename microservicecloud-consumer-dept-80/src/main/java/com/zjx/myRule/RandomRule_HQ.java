package com.zjx.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Alex
 * @Desc <p></p>
 * @Date 2018/9/1 18:55
 */
public class RandomRule_HQ extends AbstractLoadBalancerRule {


    private int currentIndex = 0;
    private int total = 0;

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size(); //随机种子数
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            //RandomRule源码
           /* int index = chooseRandomInt(serverCount);
            server = upList.get(index);
            */
            /**
             * 问题:依旧轮询策略,但是加上新需求,每个服务器要求被调用5次.也即
             * 以前是每台机器一次,现在是每台机器5次
             */
           if(total < 5){
               server = upList.get(currentIndex);
               total++;
           }else{
               total = 0;
               currentIndex++;
               if(currentIndex >= serverCount){
                   currentIndex =0;
               }
           }


            System.out.println(String.format("total:%d,currentIndex:%d",total,currentIndex));







            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
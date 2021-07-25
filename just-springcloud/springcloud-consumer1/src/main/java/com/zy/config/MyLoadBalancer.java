
package com.zy.config;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class MyLoadBalancer extends AbstractLoadBalancerRule {

    private int total = 0;// 调用了几次
    private int currentIndex = 0;// 当前调用者

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        List<Server> reachableServers = lb.getReachableServers();
        if (CollectionUtils.isEmpty(reachableServers)) {
            return null;
        }
        
        Server server = null;
        if (total < 3) {
            server = reachableServers.get(currentIndex);
            total++;
        } else {
            total = 1;
            currentIndex++;
            if (currentIndex >= reachableServers.size()) {
                currentIndex = 0;
            }
            server = reachableServers.get(currentIndex);
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }

}

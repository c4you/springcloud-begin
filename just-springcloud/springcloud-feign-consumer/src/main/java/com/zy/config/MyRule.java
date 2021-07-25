package com.zy.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
@Configuration
public class MyRule {
    
    // spring-cloud-starter-netflix-eureka-client  3.0.0及之后的版本 切换负载均衡算法方式
//	@Bean
//	ReactorLoadBalancer<ServiceInstance> myRandomLoadBalancer(Environment environment,
//			LoadBalancerClientFactory loadBalancerClientFactory) {
//		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),
//				name);
//	}
	
    // spring-cloud-starter-netflix-eureka-client  2.2.9.RELEASE及之前的版本 切换负载均衡算法方式
    @Bean
    IRule myRandomRule() {
        return new RandomRule();
    }
	
	
}

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
    
//	@Bean
//	ReactorLoadBalancer<ServiceInstance> myRandomLoadBalancer(Environment environment,
//			LoadBalancerClientFactory loadBalancerClientFactory) {
//		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),
//				name);
//	}
	
    @Bean
    IRule myRandomRule() {
        return new RandomRule();
    }
	
	
}

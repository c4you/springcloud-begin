package com.zy.eureka;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import com.netflix.appinfo.InstanceInfo;

//@Component
public class EurekaStatusChangeListener {

	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) {
		String serverId = event.getServerId();
		System.err.println(serverId + ":" + event.getAppName() + "服务下线");
	}

	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		InstanceInfo instanceInfo = event.getInstanceInfo();
		String instanceId = instanceInfo.getInstanceId();
		System.err.println(instanceId + ":" + instanceInfo.getAppName() + "服务注册");
	}

	@EventListener
	public void listen(EurekaServerStartedEvent event) {
		Object source = event.getSource();
		System.err.println(source + "\r\n服务启动");
	}

	@EventListener
	public void listen(EurekaInstanceRenewedEvent event) {
		InstanceInfo instanceInfo = event.getInstanceInfo();
		String instanceId = instanceInfo.getInstanceId();
		System.err.println(instanceId + ":" + instanceInfo.getAppName() + "服务Renewed");
	}

	
	@EventListener
	public void listen(EurekaRegistryAvailableEvent event) {
		Object source = event.getSource();
		System.err.println(source + "\r\n服务Available");
	}
}

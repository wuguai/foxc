package com.foxc.framework.eureka.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("appName : {} 进行注册",instanceInfo.getAppName());
    }

     @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        log.info("serviceId : {} , appName : {} , 服务下线。",event.getServerId(),event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event){
        log.info("appName : {} , serviceId : {} 服务续约" , event.getAppName(),event.getServerId() );
    }

}

package com.foxc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @SpringCloudApplication
 * 包含 @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，
 * 分别是SpringBoot注解、注册服务中心Eureka注解、断路器注解
 */
@SpringCloudApplication
@EnableConfigServer
public class FoxcConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxcConfigServerApplication.class, args);
    }

}

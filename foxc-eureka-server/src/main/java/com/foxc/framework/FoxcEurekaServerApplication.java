package com.foxc.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FoxcEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxcEurekaServerApplication.class);
    }

}

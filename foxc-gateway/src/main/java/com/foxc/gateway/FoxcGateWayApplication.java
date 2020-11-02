package com.foxc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class FoxcGateWayApplication {


    public static void main(String[] args) {
        SpringApplication.run(FoxcGateWayApplication.class, args);
    }

}

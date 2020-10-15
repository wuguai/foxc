package com.foxc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FoxcGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxcGatewayApplication.class, args);
    }

}

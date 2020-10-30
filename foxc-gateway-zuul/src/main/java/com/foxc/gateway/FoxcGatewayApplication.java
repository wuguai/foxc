package com.foxc.gateway;

import com.foxc.gateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy
public class FoxcGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxcGatewayApplication.class, args);
    }

    /**
     * 实例化AccessFilter
     * @return
     */
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

}

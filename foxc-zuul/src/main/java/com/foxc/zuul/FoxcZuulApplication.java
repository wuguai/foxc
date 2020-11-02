package com.foxc.zuul;

import com.foxc.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy
public class FoxcZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxcZuulApplication.class, args);
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

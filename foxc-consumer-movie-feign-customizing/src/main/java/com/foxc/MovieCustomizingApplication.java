package com.foxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCustomizingApplication.class);
    }
}

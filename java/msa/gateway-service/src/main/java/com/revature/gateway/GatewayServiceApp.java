package com.revature.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApp.class, args);
    }

}

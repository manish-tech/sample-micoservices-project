package com.manish.mydiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyDiscoveryServer {
    public static void main(String[] args) {
        SpringApplication.run(MyDiscoveryServer.class,args);
    }
}

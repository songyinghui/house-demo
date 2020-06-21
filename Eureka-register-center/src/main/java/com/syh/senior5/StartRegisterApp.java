package com.syh.senior5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StartRegisterApp {
    public static void main(String[] args) {
        SpringApplication.run(StartRegisterApp.class,args);
    }
}


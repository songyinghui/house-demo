package com.syh.senior5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.syh.senior5.mapper")
public class StartHouseServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(StartHouseServiceApp.class,args);
    }
}

package com.vibhusha.logonservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.vibhusha"})
public class LogonServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(LogonServiceApplication.class, args);
    }

}

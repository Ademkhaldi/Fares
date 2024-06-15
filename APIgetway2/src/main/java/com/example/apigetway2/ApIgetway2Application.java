package com.example.apigetway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude = ConfigurationPropertiesRebinderAutoConfiguration.class)
@EnableZuulProxy
@EnableHystrix
public class ApIgetway2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApIgetway2Application.class, args);
    }

}

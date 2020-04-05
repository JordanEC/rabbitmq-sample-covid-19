package com.jordanec.rabbitmq_sample_covid_19.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jordanec.rabbitmq_sample_covid_19.model")
public class App
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

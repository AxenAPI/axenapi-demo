package com.example.demo;

import axenapi.generated.ExampleTopicExampleGroupProducer;
import axenapi.generated.model.ExampleIn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo","swagger4kafka.client"})
public class GeneratorClientSpringBoot2 {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorClientSpringBoot2.class, args);
    }
}

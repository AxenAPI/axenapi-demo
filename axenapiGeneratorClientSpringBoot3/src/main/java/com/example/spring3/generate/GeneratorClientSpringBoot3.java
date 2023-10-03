package com.example.spring3.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class GeneratorClientSpringBoot3 {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorClientSpringBoot3.class, args);
    }

}

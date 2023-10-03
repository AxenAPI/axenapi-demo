package com.example.spring3.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class GeneratorServerSpringBoot3 {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorServerSpringBoot3.class, args);
    }

}

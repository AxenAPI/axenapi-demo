package com.example.spring3.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableKafka
public class DemoSpring3GenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpring3GenerateApplication.class, args);
    }

}

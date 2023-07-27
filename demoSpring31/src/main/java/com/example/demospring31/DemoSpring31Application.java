package com.example.demospring31;

import org.axenix.swagger4kafka.annotation.configuration.KafkaClientConfig;
import org.axenix.swagger4kafka.annotation.configuration.Swagger4KafkaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import({KafkaClientConfig.class, Swagger4KafkaConfiguration.class})
public class DemoSpring31Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpring31Application.class, args);
    }

}

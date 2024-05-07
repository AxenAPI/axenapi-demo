package com.example.demorabbit;

import axenapi.listener.NewQueueListener;
import axenapi.listener.service.NewQueueService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final NewQueueService newQueueService;

    public Config(NewQueueService newQueueService) {
        this.newQueueService = newQueueService;
    }

    @Bean
    public NewQueueListener newQueueListener(NewQueueService service) {
        return new NewQueueListener(newQueueService);
    }
}

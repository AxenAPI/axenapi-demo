package com.example.demorabbit;

import axenapi.listener.service.NewQueueService;
import axenapi.model.ExampleMessage;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NewQueueServiceImpl implements NewQueueService {
    @Override
    public void handleExampleMessage(ExampleMessage exampleMessage, Map<String, String> headers) {
        // place for your logic
        System.out.println(exampleMessage.getMessage());
    }
}

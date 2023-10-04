package com.example.demo;

import axenapi.generated.ExampleTopicExampleGroupListener;
import axenapi.generated.model.ExampleIn;
import axenapi.generated.model.ExampleOut;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@KafkaListener(topics = "example_topic", groupId = "example_group")
public class MyHandler implements ExampleTopicExampleGroupListener {

    @Override
    public ExampleOut handleExampleIn(@Payload ExampleIn examplein, @Headers Map<String, String> headers) {
        System.out.println("Handle: " + examplein.getMessage());
        return null;
    }
}

package com.example.demo.kafka.listeners;

import com.example.demo.annotation.MyKafkaHandler;
import com.example.demo.dto.ExampleMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "my_annotation", groupId = "my_annotation")
public class MyKafkaHandlerAnnotaion {

    @MyKafkaHandler
    public void listenGroupFoo(ExampleMessage message) {
        System.out.println("Received Message in group foo: " + message);
    }

}

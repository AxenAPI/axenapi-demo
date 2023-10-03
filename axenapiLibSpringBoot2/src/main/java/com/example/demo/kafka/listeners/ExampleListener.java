package com.example.demo.kafka.listeners;

import com.example.demo.dto.ExampleMessage;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "my_topic", groupId = "foo")
public class ExampleListener {

    @KafkaHandler
    public void listenGroupFoo(ExampleMessage message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaHandler(isDefault = true)
    public void listenGroupFoo(Object message) {
        System.out.println("Received Message in group foo Object listener: " + message);
    }
}

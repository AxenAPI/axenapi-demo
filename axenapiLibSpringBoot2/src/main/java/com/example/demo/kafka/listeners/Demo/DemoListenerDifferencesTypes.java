package com.example.demo.kafka.listeners.Demo;

import com.example.demo.dto.ExampleMessage;
import com.example.demo.kafka.model.Subordinate;
import pro.axenix_innovation.axenapi.annotation.*;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@KafkaListener(topics = {"demo_topic"}, groupId = "foo")
public class DemoListenerDifferencesTypes {

    @KafkaHandler
    @KafkaHandlerDescription("Принимает  ExampleMessage. Находится в DemoListener. Ничего не возвращает.")
    @KafkaHandlerHeaders( headers = {
            @KafkaHandlerHeader(header = "header_1", required = true),
            @KafkaHandlerHeader(header = "header_2")
    })
    @KafkaSecured
    @KafkaHandlerTags(tags = {"demo"})
    public void listenGroupFoo(@Payload ExampleMessage message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaHandler
    @KafkaHandlerDescription("Принимает  Subordinate. Находится в DemoListener. Ничего не возвращает.")
    @KafkaHandlerTags(tags = {"demo"})
    public void listenGroupFoo(@Payload Subordinate message) {
        System.out.println("Received Message in group foo: " + message);
    }
}

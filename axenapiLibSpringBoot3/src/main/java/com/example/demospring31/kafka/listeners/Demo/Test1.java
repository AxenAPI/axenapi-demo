package com.example.demospring31.kafka.listeners.Demo;


import com.example.demospring31.kafka.listeners.model.model.ExampleMessage;
import com.example.demospring31.kafka.listeners.model.model.Subordinate;
import pro.axenix_innovation.axenapi.annotation.KafkaHandlerDescription;
import pro.axenix_innovation.axenapi.annotation.KafkaHandlerResponse;
import pro.axenix_innovation.axenapi.annotation.KafkaHandlerHeader;
import pro.axenix_innovation.axenapi.annotation.KafkaHandlerHeaders;
import pro.axenix_innovation.axenapi.annotation.KafkaHandlerTags;
import pro.axenix_innovation.axenapi.annotation.KafkaSecured;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@KafkaListener(topics = {"test1"}, groupId = "test1")
public class Test1 {

    @KafkaHandler
    @KafkaHandlerDescription("test description")
    @KafkaHandlerHeaders( headers = {
            @KafkaHandlerHeader(header = "header_1", required = true),
            @KafkaHandlerHeader(header = "header_2")
    })
//    @KafkaHandlerResponse(payload = Subordinate.class, replayTopic = "replayTopic")
    @KafkaHandlerTags(tags = "test_tag")
    @KafkaSecured
    public void listenGroupFoo(@Payload ExampleMessage message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaHandler
//    @KafkaHandlerResponse(payload = ExampleMessage.class)
    @KafkaSecured(name = "test_security_scheme")
    public void listenGroupFoo(@Payload Subordinate message) {
        System.out.println("Received Message in group foo: " + message);
    }
}

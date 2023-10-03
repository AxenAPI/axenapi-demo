package com.example.demo.kafka.listeners.Demo;

import com.example.demo.dto.ExampleMessage;
import com.example.demo.kafka.model.Subordinate;
import org.axenix.axenapi.annotation.KafkaHandlerDescription;
import org.axenix.axenapi.annotation.KafkaHandlerResponse;
import org.axenix.axenapi.annotation.KafkaHandlerTags;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import swagger4kafka.model.Chief;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@KafkaListener(topics = {"demo_topic_with_response"}, groupId = "foo")
public class DemoListenerResponse {
    @KafkaHandler
    @KafkaHandlerDescription("Принимает  Subordinate. Находится в DemoListener. Ничего не возвращает.")
    @KafkaHandlerTags(tags = {"demo"})
    public CompletableFuture<ExampleMessage> appLoanCreate(@Payload Chief request,
                                                           @Headers Map<String, Object> headers,
                                                           Acknowledgment ack
    ) {
        ExampleMessage message = new ExampleMessage(request.getName());
        return CompletableFuture.completedFuture(message);
    }

    @KafkaHandler
    @KafkaHandlerDescription("Принимает  Subordinate. Находится в DemoListener. Ничего не возвращает.")
    @KafkaHandlerResponse(replayTopic = "response_topic", payload = ExampleMessage.class)
    @KafkaHandlerTags(tags = {"demo"})
    public CompletableFuture<ExampleMessage> appLoanCreate(@Payload Subordinate request,
                                                           @Headers Map<String, Object> headers,
                                                           Acknowledgment ack
    ) {
        ExampleMessage message = new ExampleMessage(request.getName());
        return CompletableFuture.completedFuture(message);
    }
}

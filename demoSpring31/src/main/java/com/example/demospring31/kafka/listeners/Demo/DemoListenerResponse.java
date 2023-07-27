package com.example.demospring31.kafka.listeners.Demo;



import com.example.demospring31.kafka.listeners.model.model.Chief;
import com.example.demospring31.kafka.listeners.model.model.ExampleMessage;
import com.example.demospring31.kafka.listeners.model.model.Subordinate;
import org.axenix.swagger4kafka.annotation.KafkaHandlerDescription;
import org.axenix.swagger4kafka.annotation.KafkaHandlerResponse;
import org.axenix.swagger4kafka.annotation.annotation.KafkaHandlerTags;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

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

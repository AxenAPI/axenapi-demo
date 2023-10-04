package com.example.demo.kafka.listeners;


import com.example.demo.annotation.MyKafkaHandler;
import org.axenix.axenapi.annotation.*;
import axenapi.model.Chief;
import com.example.demo.kafka.model.Subordinate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@KafkaListener(topics = "multiType", groupId = "group-2")
@SendTo
public class ClassLevelAnnotationListenerWithModifications {
    @KafkaHandler
    @KafkaHandlerTags(tags = {"group-2", "chief"})
    @KafkaHandlerDescription("Message listener with Chief payload type")
    public void handleChief(@Payload Chief chief, @Headers Map<String, Object> headers) {
        System.out.printf("group-2 >> chief received: %s\n" +
                "Headers: %s\n",
                chief, headers);
    }

    @MyKafkaHandler
    @KafkaHandlerResponse(payload = Subordinate.class)
    @KafkaHandlerTags(tags = {"group-2", "subordinate"})
    @KafkaHandlerDescription("Message listener with Subordinate payload type")
    @KafkaHandlerHeaders(headers = {
            @KafkaHandlerHeader(header = "req")
    })
    public void handleSubordinate(@Payload Subordinate subordinate, MessageHeaders headers, ConsumerRecord record) {
        System.out.printf("group-2 >> subordinate received: %s\n" +
                "Headers: %s\n" +
                "Raw message: %s\n",
                subordinate, headers, record);
    }

    @KafkaHandler(isDefault = true)
    @KafkaHandlerTags(tags = {"group-2", "default handler"})
    @KafkaHandlerDescription("Message listener with payload type other then Chief or Subordinate")
    @KafkaHandlerHeaders(headers = {
            @KafkaHandlerHeader(header = "req1", required = true),
            @KafkaHandlerHeader(header = "req2")
    })
    public void handleObject(@Payload Object o, @Headers Map<String, Object> headers) {
        System.out.println("group-2 >> Unknown type received: " + o + " with headers: " + headers);
    }
}

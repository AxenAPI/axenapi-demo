package com.example.demo.kafka.listeners;


import org.axenix.axenapi.annotation.KafkaHandlerDescription;
import org.axenix.axenapi.annotation.KafkaHandlerTags;
import org.axenix.axenapi.annotation.KafkaSecured;
import axenapi.model.Chief;
import com.example.demo.kafka.model.Subordinate;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@KafkaListener(topics = "multiType", groupId = "group-1")
public class ClassLevelAnnotationListener {
    @KafkaHandler
    @KafkaHandlerTags(tags = {"chief"})
    @KafkaHandlerDescription("Message listener with Chief payload type")
    @KafkaSecured
    public void handleChief(Chief chief) {
        System.out.printf("group-1 >> chief received: " + chief);
    }

    @KafkaHandler
    @KafkaHandlerTags(tags = {"subordinate"})
    @KafkaHandlerDescription("Message listener with Subordinate payload type")
    public void handleSubordinate(Subordinate subordinate) {
        System.out.println("group-1 >> subordinate received: " + subordinate);
    }

    @KafkaHandler(isDefault = true)
    @KafkaHandlerTags(tags = {"default handler"})
    @KafkaHandlerDescription("Message listener with payload type other then Chief or Subordinate")
    public void handleObject(Object o) {
        System.out.println("group-1 >> Unknown type received: " + o);
    }
}

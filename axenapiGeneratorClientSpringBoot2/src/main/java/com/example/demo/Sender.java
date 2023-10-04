package com.example.demo;

import axenapi.generated.ExampleTopicExampleGroupProducer;
import axenapi.generated.model.ExampleIn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class Sender {
    private final ExampleTopicExampleGroupProducer producer;

    public Sender(ExampleTopicExampleGroupProducer producer) {
        this.producer = producer;
    }

    @Transactional
    public void send() {
        ExampleIn exampleIn = new ExampleIn();
        exampleIn.setMessage("test message");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("header1", "header1");
        stringStringHashMap.put("header2", "header2");
        producer.sendExampleIn(exampleIn, stringStringHashMap);
    }

}

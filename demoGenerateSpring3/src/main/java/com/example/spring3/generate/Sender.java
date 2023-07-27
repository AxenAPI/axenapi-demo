package com.example.spring3.generate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swagger4kafka.client.MultitypeGroup1Producer;
import swagger4kafka.model.Chief;

import java.util.HashMap;

@Service
public class Sender {
    private final MultitypeGroup1Producer producer;

    public Sender(MultitypeGroup1Producer producer) {
        this.producer = producer;
    }

    @Transactional
    public void send() {
        Chief chief = new Chief();
        chief.setName("name");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("header1", "header1");
        stringStringHashMap.put("header2", "header2");
        producer.sendChief(chief, stringStringHashMap);
    }

}

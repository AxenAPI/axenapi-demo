package com.example.spring3.generate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final Sender sender;

    public MyController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping("/send")
    public void get(){
        sender.send();
    }
}

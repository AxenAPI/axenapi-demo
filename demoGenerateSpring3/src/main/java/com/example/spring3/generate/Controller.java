package com.example.spring3.generate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Sender sender;

    public Controller(Sender sender) {
        this.sender = sender;
    }

    @GetMapping("/send")
    public void get(){
        sender.send();
    }
}

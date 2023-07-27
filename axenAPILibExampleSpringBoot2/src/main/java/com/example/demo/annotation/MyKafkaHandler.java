package com.example.demo.annotation;


import org.springframework.kafka.annotation.KafkaHandler;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@KafkaHandler
public @interface MyKafkaHandler {
}

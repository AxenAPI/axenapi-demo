package com.example.demo.kafka.listeners;

import axenapi.model.Chief;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(topics = {"my_compitable_future_void"}, groupId = "foo")
public class CompetableFutureVoidKafkaListener {
    /**
     * Метод создания заявки
     *
     * @param request - запрос
     * @return - результат выполнения запроса
     */
    @KafkaHandler
    public CompletableFuture<Void> appLoanCreate(@Payload Chief request,
                                                           @Headers Map<String, Object> headers,
                                                           Acknowledgment ack
    ) {
        return CompletableFuture.completedFuture(null);
    }
}

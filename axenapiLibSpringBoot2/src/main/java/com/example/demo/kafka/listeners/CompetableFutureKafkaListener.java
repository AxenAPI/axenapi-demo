package com.example.demo.kafka.listeners;

import com.example.demo.dto.ExampleMessage;
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

/**
 * @author pavel.liamin on 23-Sep-22
 */
@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(topics = {"my_compitable_future"}, groupId = "foo")
public class CompetableFutureKafkaListener {


    /**
     * Метод создания заявки
     *
     * @param request - запрос
     * @return - результат выполнения запроса
     */
    @KafkaHandler
    public CompletableFuture<ExampleMessage> appLoanCreate(@Payload Chief request,
                                                           @Headers Map<String, Object> headers,
                                                           Acknowledgment ack
    ) {
        ExampleMessage message = new ExampleMessage(request.getName());
        return CompletableFuture.completedFuture(message);
    }
}

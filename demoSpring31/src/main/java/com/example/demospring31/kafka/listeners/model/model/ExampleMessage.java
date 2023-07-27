package com.example.demospring31.kafka.listeners.model.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.axenix.swagger4kafka.annotation.utils.KafkaMessage4Swagger;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Schema(description = "example message")
public class ExampleMessage extends KafkaMessage4Swagger {
    @Schema(description = "example field")
    private String message;
}

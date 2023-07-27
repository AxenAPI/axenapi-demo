package com.example.demospring31.kafka.listeners.model.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axenix.swagger4kafka.annotation.utils.KafkaMessage4Swagger;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for chief creating")
public class Chief extends KafkaMessage4Swagger implements Serializable {
    @NotBlank
    @Size(max = 20, min = 3)
    @Schema(description = "chief name")
    private String name;
}

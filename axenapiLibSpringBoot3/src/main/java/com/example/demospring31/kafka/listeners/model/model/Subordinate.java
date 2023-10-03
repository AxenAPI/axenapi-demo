package com.example.demospring31.kafka.listeners.model.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Subordinate DTO")
public class Subordinate {
    @NotBlank
    @Size(max = 20, min = 3)
    @Schema(description = "Subordinate name", example = "chief")
    String name;

    @NotBlank
    @Size(max = 20, min = 3)
    @Schema(description = "chief name of Subordinate", example = "Petrov")
    String chiefName;
}

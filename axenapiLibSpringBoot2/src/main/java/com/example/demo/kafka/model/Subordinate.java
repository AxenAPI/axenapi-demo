package com.example.demo.kafka.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

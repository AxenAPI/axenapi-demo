package com.example.demo.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Информация о пользователе")
public class UserResponseDTO {
    @Schema(description = "Id пользователя.")
    private Long id;

    @Schema(description = "Никнейм пользователя.")
    private String nickname;

    @Schema(description = "Email пользователя.")
    @Email
    private String email;
}

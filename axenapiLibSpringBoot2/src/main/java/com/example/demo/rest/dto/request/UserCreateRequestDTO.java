package com.example.demo.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@Schema(description = "UserCreateRequestDTO используется для создания пользователя")
public class UserCreateRequestDTO {

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min = 2, max = 20)
    @Schema(description = "Никнейм пользователя")
    protected String nickname;

    @NotNull
    @Email
    @Schema(description = "Email пользователя")
    protected String email;
}

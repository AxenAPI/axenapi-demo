package com.example.demo.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Schema(description = "UserUpdateRequestDTO используется для редактирования пользователя")
public class UserUpdateRequestDTO extends UserCreateRequestDTO {
    @NotNull
    @Schema(description = "id редактируемого пользователя.")
    private Long id;
}

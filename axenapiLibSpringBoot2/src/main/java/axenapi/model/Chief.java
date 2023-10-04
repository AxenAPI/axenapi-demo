package axenapi.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for chief creating")
public class Chief implements Serializable {
    @NotBlank
    @Size(max = 20, min = 3)
    @Schema(description = "chief name")
    private String name;
}

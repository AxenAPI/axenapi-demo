package axenapi.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.axenix_innovation.axenapi.annotation.Outgoing;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for chief creating")
@Outgoing(topics = {"qqq_in", "qqq_in2"}, type = Outgoing.Type.EVENT)
public class Chief implements Serializable {
    @NotBlank
    @Size(max = 20, min = 3)
    @Schema(description = "chief name")
    private String name;
}

package algebra.spring_boot.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCategoryDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}

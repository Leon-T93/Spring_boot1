package algebra.spring_boot.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCategoryDto {

    private String name;

    private String description;
}

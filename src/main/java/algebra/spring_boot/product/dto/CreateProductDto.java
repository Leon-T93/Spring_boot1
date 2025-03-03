package algebra.spring_boot.product.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateProductDto {

    @NotBlank
    @Size(min = 3,max = 13) //moze samo min ili samo max-nemora oba
    private String name;

    @NotNull
    //@Min(2)
    //@Max(5)
    @PositiveOrZero
    private Integer quantity;

    @NotNull
    @NotEmpty  //za listu
    @Size(min = 1,max = 2) // min i notempty netreba zajedno jer isto rade
    private List<Integer> grades;
}

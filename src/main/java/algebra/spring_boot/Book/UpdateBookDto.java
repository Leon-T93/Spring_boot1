package algebra.spring_boot.Book;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UpdateBookDto {

    @NotBlank
    @Size(min = 3)
    private String title;

    @NotBlank
    private String author;

    @Min(15000101)
    @Max(20250101)
    private Date yearPublished;

    @Min(1)
    private Double price;
}

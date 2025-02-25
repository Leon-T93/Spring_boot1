package algebra.spring_boot.Book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class Book {

    private Long id;

    private String title;

    private String author;

    @JsonFormat(pattern = "yyyyMMdd")
    private Date yearPublished;

    private Double price;
}

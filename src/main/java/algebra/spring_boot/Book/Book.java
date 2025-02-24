package algebra.spring_boot.Book;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class Book {

    private Long id;

    private String title;

    private String author;

    private Date yearPublished;

    private Double price;
}

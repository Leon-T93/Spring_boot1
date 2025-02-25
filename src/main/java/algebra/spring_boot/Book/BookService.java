package algebra.spring_boot.Book;


import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class BookService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    static { sdf.setTimeZone(TimeZone.getTimeZone("UTC")); }


    public Book create (CreateBookDto dto) {
        return new Book(1L,dto.getTitle(),dto.getAuthor(),dto.getYearPublished(),dto.getPrice());
    }

    public Book update(Long id, UpdateBookDto dto) throws ParseException {
        Date yearPublished = sdf.parse("20010101");
        Book book = new Book(id,"Plaza","Ante Antic",yearPublished,99.99);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setYearPublished(dto.getYearPublished());
        book.setPrice(dto.getPrice());

        return book;
    }

    public Book findById (Long id) throws ParseException {
        Date yearPublished = sdf.parse("20010101");
        return new Book(id,"Plaza","Ante Antic",yearPublished,99.99);
    }

    public List<Book> fetchAll () throws ParseException {
        Date yearPublished = sdf.parse("20010101");
        Date yearPublished2 = sdf.parse("20200509");
        return List.of(new Book(1L,"Plaza","Ante Antic",yearPublished,99.99), new Book(2L,"More","Petra Peric",yearPublished2,199.99));
    }

    public void delete (Long id) {
        System.out.println("Book is deleted from database by id: "+ id);
    }
}

package algebra.spring_boot.Book;


import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    public Book create (CreateBookDto dto) {
        return new Book(1L,dto.getTitle(),dto.getAuthor(),dto.getYearPublished(),dto.getPrice());
    }

    public Book update(Long id, UpdateBookDto dto) throws ParseException {
        Book book = new Book(id,"Plaza","Ante Antic",new SimpleDateFormat("yyyyMMdd").parse("20010101"),99.99);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setYearPublished(dto.getYearPublished());
        book.setPrice(dto.getPrice());

        return book;
    }

    public Book findById (Long id) throws ParseException {
        return new Book(id,"Plaza","Ante Antic",new SimpleDateFormat("yyyyMMdd").parse("20010101"),99.99);
    }

    public List<Book> fetchAll () throws ParseException {
        return List.of(new Book(1L,"Plaza","Ante Antic",new SimpleDateFormat("yyyyMMdd").parse("20010101"),99.99), new Book(2L,"More","Petra Peric",new SimpleDateFormat("yyyyMMdd").parse("20200509"),199.99));
    }

    public void delete (Long id) {
        System.out.println("Book is deleted from database by id: "+ id);
    }
}

package algebra.spring_boot.Book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id)throws ParseException {
        Book book= bookService.findById(1L);
        return ResponseEntity.ok(book);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> fetchAll()throws ParseException{
        List<Book> books= bookService.fetchAll();
        return ResponseEntity.ok(books);
    }

    @PostMapping()
    public ResponseEntity<Book> create(@Valid @RequestBody CreateBookDto dto) {

        Book book= bookService.create(dto);
        return ResponseEntity.status(201).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@Valid @RequestBody UpdateBookDto dto, @PathVariable Long id)throws ParseException{
        Book book= bookService.update(id, dto);
        return ResponseEntity.status(200).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.status(204).build();
    }


}

package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> fetchAll () {
        List<Article> articles = articleService.fetchAll();
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Integer id) {
        Optional<Article> article= articleService.findById(id);

        if (article.isEmpty()) {
            return ResponseEntity.status(404).build();

        }

        return ResponseEntity.status(200).body(article.get());
    }

    @PostMapping()
    public ResponseEntity<Article> create (@Valid @RequestBody CreateArticleDto dto) {
        Article article = articleService.create(dto);
        return ResponseEntity.status(200).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update (@Valid @RequestBody UpdateArticleDto dto, @PathVariable Integer id) {
        Article article = articleService.update(id,dto);
        return ResponseEntity.status(200).body(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        Optional<Article> article= articleService.findById(id);

        if (article.isEmpty()) {
            return ResponseEntity.status(404).build();

        }
        articleService.delete(id);
        return ResponseEntity.status(204).build();
    }
}

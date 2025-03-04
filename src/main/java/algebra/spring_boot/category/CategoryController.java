package algebra.spring_boot.category;

import algebra.spring_boot.category.dto.CreateCategoryDto;
import algebra.spring_boot.category.dto.UpdateCategoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> fetchAll () {
        List<Category> categories = categoryService.fetchAll();
        return ResponseEntity.status(200).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById (@PathVariable Integer id) {
        Optional<Category> category = categoryService.findById(id);

        if (category.isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(category.get());
    }

    @PostMapping
    public ResponseEntity<Category> create (@Valid @RequestBody CreateCategoryDto dto) {
        Category category = categoryService.create(dto);
        return ResponseEntity.status(200).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update (@Valid @RequestBody UpdateCategoryDto dto, @PathVariable Integer id) {
        Category category = categoryService.update(id,dto);
        return ResponseEntity.status(200).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        Optional<Category> category= categoryService.findById(id);

        if (category.isEmpty()) {
            return ResponseEntity.status(404).build();

        }
        categoryService.delete(id);
        return ResponseEntity.status(204).build();
    }
}

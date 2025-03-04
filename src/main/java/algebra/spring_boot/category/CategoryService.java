package algebra.spring_boot.category;

import algebra.spring_boot.category.dto.CreateCategoryDto;
import algebra.spring_boot.category.dto.UpdateCategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> fetchAll ();

    Optional<Category> findById (Integer id);

    Category create (CreateCategoryDto dto);

    Category update (Integer id, UpdateCategoryDto dto);

    void delete (Integer id);
}

package algebra.spring_boot.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> fetchAll ();

    Optional<Category> findById (Integer id);

    Category create (Category category);

    Category update (Category category);

    void delete (Integer id);
}

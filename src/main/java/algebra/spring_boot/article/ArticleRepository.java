package algebra.spring_boot.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// drugi parametar u japa repository je koji tip je primary key-u Article klasi je to integer id-znaci integer
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("SELECT a FROM Article a WHERE a.category.name = :name")
    Optional<Article> findByCategoryName(String name);

    Optional<Article> findByName(String name);

}

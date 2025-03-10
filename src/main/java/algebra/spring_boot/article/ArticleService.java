package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> findByPriceGreaterThanEqualAndPriceLessThanEqualAndCategory_id (BigDecimal low, BigDecimal high, Integer id);

    List<Article> findByNameIgnoreCaseIsOrDescriptionIgnoreCaseIs (String name, String description);

    Optional<Article> findTop1ByPriceOrderByPriceDescContainingCategory_id (Integer id);
















    List<Article> fetchAll ();

    Optional<Article> findById (Integer id);

    Article create (CreateArticleDto dto);

    Article update (Integer id, UpdateArticleDto dto);

    void delete (Integer id);


}

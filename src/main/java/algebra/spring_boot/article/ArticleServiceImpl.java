package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;
import algebra.spring_boot.category.Category;
import algebra.spring_boot.category.CategoryRepositoryImpl;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final CategoryRepositoryImpl categoryRepositoryImpl;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepositoryImpl categoryRepositoryImpl) {
        this.articleRepository = articleRepository;    // umjesto @RequiredArgsConstructor
        this.categoryRepositoryImpl = categoryRepositoryImpl;
    }



    @Override
    public List<Article> findByPriceGreaterThanEqualAndPriceLessThanEqualAndCategory_id (BigDecimal low, BigDecimal high, Integer id) {
        return articleRepository.findByPriceGreaterThanEqualAndPriceLessThanEqualAndCategory_id(low,high,id);
    }

    @Override
    public List<Article> findByNameIgnoreCaseIsOrDescriptionIgnoreCaseIs (String name, String description) {
        return articleRepository.findByNameIgnoreCaseIsOrDescriptionIgnoreCaseIs(name,description);
    }

    @Override
    public Optional<Article> findTop1ByOrderByPriceDesc () {
        return articleRepository.findTop1ByOrderByPriceDesc();
    }

    @Override
    public Integer countByCategory_id (Integer id) {
        return articleRepository.countByCategory_id(id);
    }















    @Override
    public List<Article> fetchAll () {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById (Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article create (CreateArticleDto dto){
        Optional<Category> category = categoryRepositoryImpl.findById(dto.getCategoryId());

        if (category.isEmpty()) {
            throw new InternalException("Category not found");
        }

        Article article = new Article(dto.getName(),dto.getDescription(),dto.getPrice(),category.get());

        return articleRepository.save(article);
    }

    @Override
    public Article update (Integer id, UpdateArticleDto dto) {
        Optional<Article> article = articleRepository.findById(id);

        if (article.isEmpty()) {
            throw new InternalException("Article not found.");
        }

        Optional<Category> category = categoryRepositoryImpl.findById(dto.getCategoryId());
        if (category.isEmpty()) {
            throw new InternalException("Category not found");
        }

        Article articleForUpdate = article.get();
        articleForUpdate.setName(dto.getName());
        articleForUpdate.setDescription(dto.getDescription());
        articleForUpdate.setPrice(dto.getPrice());
        articleForUpdate.setCategory(category.get());

        return articleRepository.save(articleForUpdate);
    }

    @Override
    public void delete (Integer id) {
        Optional<Article> article = articleRepository.findById(id);

        if (article.isEmpty()) {
            throw new InternalException("Article not found.");
        }
        articleRepository.delete(article.get());
    }




}

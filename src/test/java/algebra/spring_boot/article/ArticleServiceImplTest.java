package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;
import algebra.spring_boot.category.Category;
import algebra.spring_boot.category.CategoryRepository;
import org.apache.logging.log4j.util.InternalException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleServiceImplTest {

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Mock
    private ArticleRepository articleRepositoryMock;

    @Mock
    private CategoryRepository categoryRepositoryMock;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSuccess(){
        CreateArticleDto dto = new CreateArticleDto("Article name", null, BigDecimal.TEN, 1);
        Category mockCategory = new Category(1, "Testna kategorija", "Nekakav description");
        Article article = new Article(dto.getName(), dto.getDescription(), dto.getPrice(), mockCategory);

        when(categoryRepositoryMock.findById(dto.getCategoryId())).thenReturn(Optional.of(mockCategory));
        when(articleRepositoryMock.save(article)).thenReturn(article);

        Article savedArticle =  articleService.create(dto);

        assertNotNull(savedArticle);
        assertEquals(savedArticle.getName(), dto.getName());
        assertEquals(savedArticle.getCategory().getId(), dto.getCategoryId());
        assertNull(savedArticle.getDescription());

        verify(articleRepositoryMock, times(1)).save(article);
        verify(categoryRepositoryMock, times(1)).findById(dto.getCategoryId());
    }

    @Test
    public void testCreateWhenCategoryNotFound(){
        CreateArticleDto dto = new CreateArticleDto("Article name", null, BigDecimal.TEN, 1);

        assertThrows(InternalException.class, () -> articleService.create(dto));
    }

    @Test
    public void testDelete () {
        CreateArticleDto dto = new CreateArticleDto("Article 1", "Description test", BigDecimal.TEN, 1);
        Category mockCategory = new Category(1, "Testna kategorija", "Nekakav description");
        Article article = new Article(dto.getName(), dto.getDescription(), dto.getPrice(), mockCategory);

        when(articleRepositoryMock.findById(article.getId())).thenReturn(Optional.of(article));

        articleService.delete(article.getId());

        verify(articleRepositoryMock, times (1)).findById(article.getId());
        verify(articleRepositoryMock, times(1)).delete(article);

    }

    @Test
    public void testDeleteWhenArticleNotFound() {
        CreateArticleDto dto = new CreateArticleDto("Article 1", "Description test", BigDecimal.TEN, 1);
        Category mockCategory = new Category(1, "Testna kategorija", "Nekakav description");
        Article article = new Article(dto.getName(), dto.getDescription(), dto.getPrice(), mockCategory);

        when(articleRepositoryMock.findById(article.getId())).thenReturn(Optional.empty());

        assertThrows(InternalException.class, () -> articleService.delete(article.getId()));
    }

    @Test
    public void testUpdate() {
        CreateArticleDto dto = new CreateArticleDto("Article 1", "Description test", BigDecimal.TEN, 1);
        UpdateArticleDto dto1 = new UpdateArticleDto("Updated Article", "Updated Description test", BigDecimal.TEN, 1);
        Category mockCategory = new Category(1, "Testna kategorija", "Nekakav description");
        Article article = new Article(dto.getName(), dto.getDescription(), dto.getPrice(), mockCategory);
        Article articleForUpdate = new Article(dto1.getName(), dto1.getDescription(), dto1.getPrice(), mockCategory);


        when(articleRepositoryMock.findById(article.getId())).thenReturn(Optional.of(article));
        when(categoryRepositoryMock.findById(dto.getCategoryId())).thenReturn(Optional.of(mockCategory));

        articleService.update(article.getId(),dto1);

        verify(articleRepositoryMock, times (1)).findById(article.getId());
        verify(categoryRepositoryMock, times(1)).findById(dto1.getCategoryId());
        verify(articleRepositoryMock, times(1)).save(articleForUpdate);
    }

    @Test
    public void testUpdateWhenArticleNotFound() {
        UpdateArticleDto dto1 = new UpdateArticleDto("Updated Article", "Updated Description test", BigDecimal.TEN, 1);
        Category mockCategory = new Category(1, "Testna kategorija", "Nekakav description");
        Article articleForUpdate = new Article(dto1.getName(), dto1.getDescription(), dto1.getPrice(), mockCategory);

        when(articleRepositoryMock.findById(articleForUpdate.getId())).thenReturn(Optional.empty());

        assertThrows(InternalException.class, () -> articleService.update(1,dto1));
    }

    @Test
    public void testUpdateWhenCategoryNotFound() {
        UpdateArticleDto dto1 = new UpdateArticleDto("Updated Article", "Updated Description test", BigDecimal.TEN, 1);
        Category mockCategory = new Category(1, "Testna kategorija", "Nekakav description");
        Article articleForUpdate = new Article(dto1.getName(), dto1.getDescription(), dto1.getPrice(), mockCategory);

        when(articleRepositoryMock.findById(dto1.getCategoryId())).thenReturn(Optional.empty());

        assertThrows(InternalException.class, () -> articleService.update(1,dto1));
    }

    @Test
    public void testFetchAll() {
        Article article1 = new Article("Article 1","Description 1", BigDecimal.TEN,new Category(1,"Category 1", "Category description 1"));
        Article article2 = new Article("Article 2","Description 2", BigDecimal.TEN,new Category(2,"Category 2", "Category description 2"));

        List<Article> articleList = new ArrayList<>();
        articleList.add(article1);
        articleList.add(article2);

        when(articleRepositoryMock.findAll()).thenReturn(articleList);

        articleService.fetchAll();

        verify(articleRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Article article = new Article("Article 1","Description 1", BigDecimal.TEN,new Category(1,"Category 1", "Category description 1"));


        when(articleRepositoryMock.findById(article.getId())).thenReturn(Optional.of(article));

        articleService.findById(article.getId());

        verify(articleRepositoryMock, times(1)).findById(article.getId());
    }


    @Test
    public void testFindByNameStartingWith() {
        Article article = new Article("Article 1","Description 1", BigDecimal.TEN,new Category(1,"Category 1", "Category description 1"));
        String name= "Art";

        when(articleRepositoryMock.findTop1ByNameLike(name + "%")).thenReturn(Optional.of(article));

        articleService.findByNameStartingWith(name);

        verify(articleRepositoryMock, times(1)).findTop1ByNameLike(name + "%");
    }



}
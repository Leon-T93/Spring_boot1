package algebra.spring_boot.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName (String name);

    List<Product> findByPriceGreaterThanEqualAndPriceLessThanEqual (BigDecimal low, BigDecimal high);

    List<Product> findByAvailableTrue ();

    List<Product> findByDescriptionContaining (String description);




    @Query("SELECT p FROM Product p WHERE p.available = FALSE")
    List<Product> findProductsThatAreNotAvailable ();

    @Query("SELECT p FROM Product p WHERE p.price NOT BETWEEN :priceLow AND :priceHigh")
    List<Product> findByPriceNotBetween (BigDecimal priceLow, BigDecimal priceHigh);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findByProductName (String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:letters%")
    List<Product> findWhereNameContainsLetters (String letters);

    @Query("SELECT p FROM Product p WHERE p.name NOT LIKE %:letters%")
    List<Product> findWhereNameDoesNotContainsLetters (String letters);

    @Query("SELECT p FROM Product p WHERE p.description IS NULL")
    List<Product> findWhereDescriptionIsNull () ;





}

package algebra.spring_boot.product;

import algebra.spring_boot.product.dto.CreateProductDto;
import algebra.spring_boot.product.dto.UpdateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

//ili @Component (skoro isto sto i @Service)
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findByName (String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByPriceBetweenValues (BigDecimal low, BigDecimal high) {
        return productRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(low,high);
    }

    public List<Product> findAvailableProducts () {
        return productRepository.findByAvailableTrue();
    }

    public List<Product> findByDescriptionContaining (String description) {
        return productRepository.findByDescriptionContaining(description);
    }

    public List<Product> findProductsThatAreNotAvailable () {
        return productRepository.findProductsThatAreNotAvailable();
    }

    public List<Product> findByPriceNotBetween (BigDecimal priceLow, BigDecimal priceHigh) {
        return productRepository.findByPriceNotBetween(priceLow,priceHigh);
    }

    public List<Product> findByProductName (String name) {
        return productRepository.findByProductName(name);
    }

    public List<Product> findWhereNameContainsLetters (String letters) {
        return productRepository.findWhereNameContainsLetters(letters);
    }

    public List<Product> findWhereNameDoesNotContainsLetters (String letters) {
        return productRepository.findWhereNameDoesNotContainsLetters(letters);
    }

    public List<Product> findWhereDescriptionIsNull () {
        return productRepository.findWhereDescriptionIsNull();
    }











    public Product create(CreateProductDto dto) {
        return new Product(12L, dto.getName());
    }

    public Product update(Long id, UpdateProductDto dto) {
        Product productFromDb= new Product(id,"old name");

        productFromDb.setName(dto.getName());

        return productFromDb;
    }

    public Product findById (Long id) {
        return new Product(id,"some name from db");
    }

    public List<Product> fetchAll () {
        return List.of(new Product(12L, "Mobitel"),new Product(15L, "Klima uredaj"));
    }

    public void delete(Long id){
        System.out.println("Product se brise iz baze podataka.... ID: " +id);
        //logika za delete producta....
    }
}

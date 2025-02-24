package algebra.spring_boot.product;

import org.springframework.stereotype.Service;

import java.util.List;

//ili @Component (skoro isto sto i @Service)
@Service
public class ProductService {

    public Product create(CreateProductDto dto) {
        return new Product(12L, dto.getName());
    }

    public Product update(Long id,UpdateProductDto dto) {
        Product productFromDb= new Product(id, "old name");

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

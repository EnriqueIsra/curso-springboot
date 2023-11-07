package academy.digitallab.store.poduct.repository;

import academy.digitallab.store.poduct.entity.Category;
import academy.digitallab.store.poduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepsitory extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}

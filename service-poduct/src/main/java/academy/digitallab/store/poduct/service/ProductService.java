package academy.digitallab.store.poduct.service;

import academy.digitallab.store.poduct.entity.Category;
import academy.digitallab.store.poduct.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> ListAllProduct();
    public Product getProduct (Long id);
    public Product createProduct (Product product);
    public Product updateProduct (Product product);
    public Product deleteProduct (Long id);
    public List<Product> findByCategory (Category category);
    public Product updateStock (Long id, Double quantity);
}

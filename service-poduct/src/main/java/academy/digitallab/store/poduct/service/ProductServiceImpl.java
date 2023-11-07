package academy.digitallab.store.poduct.service;

import academy.digitallab.store.poduct.entity.Category;
import academy.digitallab.store.poduct.entity.Product;
import academy.digitallab.store.poduct.repository.ProductRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepsitory productRepsitory;

    @Override
    public List<Product> ListAllProduct() {
        return productRepsitory.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepsitory.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepsitory.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());
        if(null == productDB){
            return null;
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());
        return productRepsitory.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB = getProduct(id);
        if(null == productDB){
            return null;
        }
        productDB.setStatus("DELETED");
        return productRepsitory.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepsitory.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB = getProduct(id);
        if(null == productDB){
            return null;
        }
        Double stock = productDB.getStock() + quantity;
        productDB.setStock(stock);
        return productRepsitory.save(productDB);
    }
}

package workshop.dao;

import workshop.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    Product addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(Product product);
    Product findProductById(int id);
}

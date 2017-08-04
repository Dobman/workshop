package workshop.dao;

import workshop.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     *
     * @return
     */
    List<Product> getAllProducts();
    Product addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(Product product);

    /**
     * Method for finding {@link Product} by id
     * @param id {@link Product} id
     * @return Product with given id or null if non was found.
     */
    Product findProductById(int id);
}

package workshop.action.product;

import workshop.action.Action;
import workshop.dao.ProductDao;
import workshop.entity.Product;

import java.util.List;
import java.util.Scanner;

public class PrintAllProductAction implements Action {

    private final ProductDao productDao;

    public PrintAllProductAction(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public String getMessage() {
        return "Print all products";
    }

    @Override
    public void doAction(Scanner scanner) {
        List<Product> allProducts = productDao.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}

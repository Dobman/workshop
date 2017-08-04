package workshop.action.product;

import workshop.action.Action;
import workshop.dao.ProductDao;
import workshop.entity.Product;

import java.util.Scanner;

public class DeleteProductAction implements Action {

    private final ProductDao productDao;

    public DeleteProductAction(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public String getMessage() {
        return "Delete product";
    }

    @Override
    public void doAction(Scanner scanner) {
        System.out.println("Insert product id");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = productDao.findProductById(id);
        if(product != null){
            productDao.removeProduct(product);
        }else{
            System.out.println("No such product");
        }
    }
}

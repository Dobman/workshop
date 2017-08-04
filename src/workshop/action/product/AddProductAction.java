package workshop.action.product;

import workshop.action.Action;
import workshop.dao.ProductDao;
import workshop.entity.Product;

import java.util.Scanner;

public class AddProductAction implements Action {

    private final ProductDao productDao;

    public AddProductAction(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public String getMessage() {
        return "Add product";
    }

    @Override
    public void doAction(Scanner scanner) {
        System.out.println("Adding product");
        System.out.println("Insert name:");
        String name = scanner.nextLine();
        System.out.println("Insert description:");
        String description = scanner.nextLine();
        System.out.println("Insert price:");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = productDao.addProduct(new Product(name, description, price));
        System.out.println("Following product was inserted: " + product);
    }
}

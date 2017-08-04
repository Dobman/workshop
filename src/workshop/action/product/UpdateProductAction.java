package workshop.action.product;

import workshop.action.Action;
import workshop.dao.ProductDao;
import workshop.entity.Product;

import java.util.Scanner;

public class UpdateProductAction implements Action {

    private final ProductDao productDao;

    public UpdateProductAction(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public String getMessage() {
        return "Update product";
    }

    @Override
    public void doAction(Scanner scanner) {
        System.out.println("Insert product id");
        int id = Integer.parseInt(scanner.nextLine());
        Product productById = productDao.findProductById(id);
        System.out.println(productById);
        if(productById != null){
            System.out.println("Insert product new name:");
            String name = scanner.nextLine();
            System.out.println("Insert product new description:");
            String description = scanner.nextLine();
            System.out.println("Insert product new price:");
            double price = Double.parseDouble(scanner.nextLine());
            productById.setName(name);
            productById.setDescription(description);
            productById.setPrice(price);
            productDao.updateProduct(productById);
        }else{
            System.out.println("No such product");
        }
    }
}
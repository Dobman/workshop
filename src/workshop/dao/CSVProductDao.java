package workshop.dao;

import workshop.entity.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CSVProductDao implements ProductDao {

    private final Path csvFilePath;
    private final Random random;

    public CSVProductDao(Path csvFilePath) {
        this.csvFilePath = csvFilePath;
        random = new Random();
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            List<String> lines = Files.readAllLines(csvFilePath);
            List<Product> products = new ArrayList<>();
            for (String line : lines) {
                Product product = mapToProduct(line);
                if(product != null){
                    products.add(product);
                }
            }
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product addProduct(Product product) {
        try {
            int id = genId(product);
            Product newProduct = new Product(id, product);
            Files.write(csvFilePath, mapToNewLine(newProduct).getBytes(),
                    StandardOpenOption.APPEND , StandardOpenOption.CREATE);
            return newProduct;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private int genId(Product product) {
        return random.nextInt();
    }

    @Override
    public void updateProduct(Product product) {
        removeProduct(product);
        addProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        List<Product> allProducts = getAllProducts();
        Product productById = findProductById(product.getId(), allProducts);
        allProducts.remove(productById);
        try {
            Files.delete(csvFilePath);
            for (Product p : allProducts) {
                addProduct(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Product findProductById(int id) {
        List<Product> allProducts = getAllProducts();
        return findProductById(id, allProducts);
    }

    private Product findProductById(int id, List<Product> allProducts) {
        for (Product product : allProducts) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private Product mapToProduct(String line) {
        String[] split = line.split(",");
        if(split.length != 4){
            return null;
        }
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        String description = split[2];
        double price = Double.parseDouble(split[3]);
        return new Product(id, name, description, price);
    }

    private String mapToNewLine(Product product) {
        return "\n" + product.getId() + "," + product.getName() + "," +
                product.getDescription() + "," + product.getPrice();
    }
}

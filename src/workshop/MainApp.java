package  workshop;

import workshop.dao.CSVProductDao;
import workshop.dao.JdbcProductDao;
import workshop.dao.ProductDao;
import workshop.option.OptionFactoryImpl;

import java.nio.file.Paths;

public class MainApp {

    public static void main(String[] args){
        ProductDao productDao =
//                new JdbcProductDao(
//                "jdbc:mysql://localhost:3306/products_ex","root","root");
                new CSVProductDao(Paths.get("products.csv"));

        ApplicationRunner applicationRunner =
                new ApplicationRunner(System.in, new OptionFactoryImpl(productDao));
        applicationRunner.run();

    }
}

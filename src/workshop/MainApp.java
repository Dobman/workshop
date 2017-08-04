package  workshop;

import workshop.dao.CSVProductDao;
import workshop.option.OptionFactoryImpl;

import java.nio.file.Paths;

public class MainApp {

    public static void main(String[] args){
        CSVProductDao csvProductDao = new CSVProductDao(Paths.get("products.csv"));
        ApplicationRunner applicationRunner =
                new ApplicationRunner(System.in, new OptionFactoryImpl(csvProductDao));
        applicationRunner.run();

    }
}

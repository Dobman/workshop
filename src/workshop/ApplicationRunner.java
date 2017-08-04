package workshop;

import workshop.option.Option;
import workshop.option.OptionFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {

    private final Scanner scanner;
    private final List<Option> optionList;

    ApplicationRunner(InputStream inputStream, OptionFactory optionFactory){
        scanner = new Scanner(inputStream);
        optionList = new ArrayList<>();
        optionList.add(optionFactory.createProductOption());
    }


    public void run(){
        System.out.println("Witaj");
        while (true){
            System.out.println("Wybierz opcje:");
            printOptions();
            Option option = findOption(getIntInput());
            System.out.println("Wybierz akcje");
            option.printActions();
            option.runAction(getIntInput(), scanner);
        }


    }

    private int getIntInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    private Option findOption(int userInput) {
        for (Option option : optionList) {
            if(option.option == userInput){
                return option;
            }
        }
        return null;
    }

    private void printOptions() {
        for (Option option : optionList) {
            System.out.println(option.option + " - " + option.message);
        }
    }
}

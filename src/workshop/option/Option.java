package workshop.option;

import workshop.action.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Option {
    public final int option;
    public final String message;
    List<Action> actions;

    Option(int option, String message) {
        this.option = option;
        this.message = message;
        this.actions = new ArrayList<>();
    }

    public void printActions(){
        for (int i=0;i<actions.size();i++) {
            System.out.println(i + " " + actions.get(i).getMessage());
        }
    }

    public void runAction(int actionNumber, Scanner scanner){
        actionNumber = Math.abs(actionNumber);
        if(actionNumber < actions.size()){
            actions.get(actionNumber).doAction(scanner);
        }else {
            System.out.println("No action was found");
        }
    }
}

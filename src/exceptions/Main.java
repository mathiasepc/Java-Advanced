package exceptions;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ExceptionsDemo.show();
            // Da Throwable er super class, til alle classes,
            // griber den alle exceptions
        } catch (Throwable e) {
            System.out.println("An unexpexted error occured.");
        }
    }
}
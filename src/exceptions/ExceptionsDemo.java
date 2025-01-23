package exceptions;

import java.io.IOException;

public class ExceptionsDemo {
    public static void show() {
        var account = new Account();
        try {
            account.withdraw(100);
        } catch (AccountException e) {
            // Her henter vi den specifikke exception(InsufficientFundException).
            // Efterfølgende printes beskeden ud fra InsufficientFundException.
            System.out.println(e.getCause().getMessage());
        }

    }
//    public static void show() {
//        try(
//                var reader = new FileReader("file.txt");
//                var writer = new FileWriter("......")
//        ) {
//            var value = reader.read();
//        } catch (IOException e) {
//            System.out.println("Could not read data.");
//        }
//    }
}

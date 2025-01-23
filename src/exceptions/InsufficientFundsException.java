package exceptions;

// Checked -> Excepton
// Unchecked (runtime) -> RuntimeException

public class InsufficientFundsException extends Exception{
    // Her laver vi en default message.
    public InsufficientFundsException(){
        super("Insufficient funds in your account.");
    }
    // Her kan du lave en custom message.
    public InsufficientFundsException(String message) {
        super(message);
    }
}

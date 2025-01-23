package exceptions;

// Chaining exceptions

// AccountException er mere en generel exception.
// Den kan tage imod andre specifikke exceptions
public class AccountException extends Exception{
    // Ved at declare Exception i constructor, kan den tage imod
    // Specifik lavet exceptions, som InsufficientFundsExceptions, som er
    // en specifik exception
    public AccountException(Exception cause){
        super(cause);
    }
}

package exceptions;

import javax.crypto.AEADBadTagException;
import java.io.IOException;

public class Account {
    private float balance;

    public void deposit(float value) throws IOException {
        if (value <= 0)
            throw new IOException("Must be greater than 0");

    }

    public void withdraw(float value) throws AccountException {
            // Her parser vi en en specifik exception ned
            // i en general exception for account.
            // Man kan parse en string tekst ned i InsufficientFundsException,
            // for at bruge den anden constructor, som er lavet
        if (value > balance)
            throw new AccountException(new InsufficientFundsException());


    }
}

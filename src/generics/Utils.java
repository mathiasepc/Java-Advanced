package generics;

// Man behøver ikke at gøre en class generisk for at bruge generisk metoder.
// Når man laver en Utils class, er der normalt, at gøre metoder static.
public class Utils {

    // Her laver vi en comparable metode.
    // For at comparable skal virke,
    // skal reference typen have en comparable lavet.
    public static <T extends Comparable<T>> T max(T first, T second) {
        return first.compareTo(second) < 0 ? first : second;
    }

    // Hvis man vil bruge forskellige typer K = Key, V = value
    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }
}

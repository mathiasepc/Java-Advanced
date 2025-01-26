package collections;

import java.util.*;

public class CollectionDemo {
    public static void show(){
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");

        // Add multiple items in one go
        Collections.addAll(collection, "a", "b", "c");

        var size = collection.size();

        collection.remove("a");
        var containsA = collection.contains("a");

        collection.clear();
        var isEmpty = collection.isEmpty();

        Collection<String> other = new ArrayList<>();
        other.add("a");
        other.add("b");
        other.add("c");

        // == referer til object reference in memory.
        System.out.println(collection == other);
        // .equals() ser på selve indholdet.
        System.out.println(collection.equals(other));
    }
}

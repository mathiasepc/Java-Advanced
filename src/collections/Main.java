package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var c1 = new Customer("a","e1");
        var c2 = new Customer("b","e2");
        Map<String,Customer> map = new HashMap<>();
        map.put(c1.getEmail(),c1);
        map.put(c2.getEmail(),c2);

        // henter en kunde
        var customer = map.get("e1");

        var unknown = new Customer("Unknown", "");

        // leder efter "e10". Hvis du ikke finder en, returner unknown
        map.getOrDefault("e10", unknown);

        // søger efter en specifik nøgle. returns boolean
        map.containsKey("e10");

        // Replace et object i HashTable
        map.replace("e1", new Customer("a++", "e1"));

        // Man kan ikke iterate på map. Men der er 3 metoder, som tillader
        // 1) får du kun key
        for(var key : map.keySet()){
            System.out.println(key);
        }
        // 2) får du både key og value
        for(var entry : map.entrySet()){
            // giver både K og V
            System.out.println(entry);
            // giver kun K
            System.out.println(entry.getKey());
            // giver V
            System.out.println(entry.getValue());
        }
        // 3) giver et customer objekt
        // De kan komme i forskellig rækkefølge
        for(var customer1 : map.values()){
            System.out.println(customer1);
        }
    }
}
/*
* !!! Set/HashSet() !!!
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a","b","c","c");
        // fjerner duplikat
        Set<String> set = new HashSet<>(collection);


        Set<String> set1 = new HashSet<>(Arrays.asList("a","b","c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b","c","d"));

        // Union, combination af 2 sets. Man kan parse queue og ArrayList.
        set1.addAll(set2);

        // beholder alle fra set2 og indsætter i set1
        set1.retainAll(set2);

        // Fjerner alle som er ens.
        set1.removeAll(set2);
* */

/*
* !!! Queue !!!
        Queue<String> queue = new ArrayDeque<>();
        // Nogen queue har en limit size.
        // add() throws an exceptions hvis man kommer også limit
        queue.add("c");
        queue.add("a");
        queue.add("b");
        // offer() return false
        queue.offer("d");
        // c er altså forrest
        // d-> b -> a -> c

        // henter første element. hvis køen er tom:
        // peek() returner null
        System.out.println(queue.peek());
        // element() throws an exception
        System.out.println(queue.element());

        // fjerner første item og returnere den.
        // throws an exception hvis queue er null
        queue.remove();
        // fjerner første første item og returnere den.
        // hvis queue er item, returner null.
        queue.poll();
* */
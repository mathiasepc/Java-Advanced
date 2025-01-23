package collections;

import generics.GenericList;

public class Main {
    public static void main(String[] args) {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (String current : list)
            System.out.println(current);
    }
}

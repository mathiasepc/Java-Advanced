package generics;

// Der er 2 konventionerne for at beskrive hvilken type man arbejder med
// <T> = type or template
// <E> = Element, det er når en class opfører sig som en collection.


import java.util.ArrayList;

// Man kan også specificere hvad T kun må være
// F.eks. Number, Comparable, String osv.
// Man kan også tilføje flere constraints: <T extends Comparable & Cloneable>
// Det betyder, at typen, som parses ind, skal have alle extends.
public class GenericList<T> {
    // Man kan ikke gøre følgende fordi den ikke ved hvad T er:
    //private T[] items = new T[10];
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}

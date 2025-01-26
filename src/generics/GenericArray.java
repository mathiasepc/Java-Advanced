package generics;

import java.util.Iterator;

// Den tager kun reference types

public class GenericArray<T> implements Iterable<T> {
    // Man kan ikke gøre følgende fordi den ikke ved hvad T er:
    // private T[] items = new T[10];
    private T[] items = (T[]) new Object[10];
    private int count;

    // tilføj til array
    public void add(T item) {
        items[count++] = item;
    }

    // hent fra array
    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        // vi parser current objektet.
        return new ListIterator(this);
    }

    // Hvis vi ændre T[] items, er der kun her vi skal ændre koden.
    // Alle steder som iterate over vores list vil ikke få en fejl.
    // Vi laver denne class her for, vi kender til items her.
    // Men hvis den skal bruges flere steder, kan man godt lave den i en class for sig.
    private class ListIterator implements Iterator<T> {
        // for array
        private GenericArray<T> list;
        private int index;

        // for et array
        public ListIterator(GenericArray<T> list){
            this.list = list;
        }

        // Er der en mere i array
        @Override
        public boolean hasNext() {
            return index < list.count;
        }

        // returner current item fra array.
        @Override
        public T next() {
            return list.items[index++];
        }
    }
}

package generics;

import java.util.Iterator;

// Den tager kun referencec types
public class GenericList<T> implements Iterable<T> {
    // Man kan ikke gøre følgende fordi den ikke ved hvad T er:
    // private T[] items = new T[10];
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        // vi parser current objektet.
        return new ListIterator(this);
    }

    // Vi laver denne class her for, vi kender til items her.
    // Hvis vi ændre items, er der kun i metoden next(), som vi skal
    // ændre koden. Alle steder som iterate over vores list vil vi
    // ikke få en fejl.
    private class ListIterator implements Iterator<T> {
        private GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list){
            this.list = list;
        }

        // Er der en mere i listen
        @Override
        public boolean hasNext() {
            return index < list.count;
        }
        // returner current item fra listen.
        @Override
        public T next() {
            return list.items[index++];
        }
    }
}

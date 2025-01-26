package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericArrayList<T> implements Iterable<T>{
    private Collection<T> items;

    public GenericArrayList() {
        items = new ArrayList<>();
    }

    public void add(T item){
        items.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
        private Iterator iterator;

        public ListIterator(GenericArrayList<T> iterator){
            this.iterator = iterator.items.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return (T) iterator.next();
        }
    }
}

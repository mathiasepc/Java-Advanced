package generics;

public class List {
    private Object[] items = new Object[10];
    private int count;

    public void add(Object item){
        // Efter at har indsat item, count gå en op.
        items[count++] = item;
    }

    public Object get(int index){
        return items[index];
    }
}

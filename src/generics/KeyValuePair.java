package generics;


// En class, som tager multiple types values
public class KeyValuePair<K,V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value){
        this.key = key;
        this.value = value;
    }
}

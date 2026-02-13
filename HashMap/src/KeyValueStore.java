package HashMap.src;

public interface KeyValueStore<K, V> {
    void set(K key, V value);
    V get(K key);
    void delete(K key);
    Entry<K, V> getRandom();
}


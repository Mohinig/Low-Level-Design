package HashMap.src;

class HashNode<K, V> {
    K key;
    V value;
    int index;
    HashNode<K, V> next;

    HashNode(K key, V value, int index) {
        this.key = key;
        this.value = value;
        this.index = index;
    }
}

package HashMap.src;

class HashIndex<K, V> {

    private static final int CAPACITY = 1024;
    private final HashNode<K, V>[] table;

    @SuppressWarnings("unchecked")
    HashIndex() {
        table = new HashNode[CAPACITY];
    }

    int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % CAPACITY;
    }

    HashNode<K, V> getNode(K key) {
        HashNode<K, V> curr = table[hash(key)];
        while (curr != null) {
            if (curr.key.equals(key)) return curr;
            curr = curr.next;
        }
        return null;
    }

    void put(HashNode<K, V> node) {
        int h = hash(node.key);
        node.next = table[h];
        table[h] = node;
    }

    void remove(K key) {
        int h = hash(key);
        HashNode<K, V> curr = table[h], prev = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) table[h] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

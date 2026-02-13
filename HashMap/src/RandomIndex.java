package HashMap.src;

class RandomIndex<K> {

    private Object[] keys = new Object[16];
    private int size = 0;

    void add(K key) {
        ensureCapacity();
        keys[size++] = key;
    }

    K get(int index) {
        return (K) keys[index];
    }

    void swapAndRemove(int index) {
        keys[index] = keys[size - 1];
        keys[size - 1] = null;
        size--;
    }

    int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == keys.length) {
            Object[] newArr = new Object[keys.length * 2];
            System.arraycopy(keys, 0, newArr, 0, keys.length);
            keys = newArr;
        }
    }
}


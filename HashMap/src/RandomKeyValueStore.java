package HashMap.src;

import java.util.Random;

public class RandomKeyValueStore<K, V> implements KeyValueStore<K, V> {

    private final HashIndex<K, V> hashIndex = new HashIndex<>();
    private final RandomIndex<K> randomIndex = new RandomIndex<>();
    private final LockManager lockManager = new LockManager();
    private final Random random = new Random();

    @Override
    public void set(K key, V value) {
        lockManager.write(() -> {
            HashNode<K, V> node = hashIndex.getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            int index = randomIndex.size();
            randomIndex.add(key);
            hashIndex.put(new HashNode<>(key, value, index));
        });
    }

    @Override
    public V get(K key) {
        HashNode<K, V> node = hashIndex.getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void delete(K key) {
        lockManager.write(() -> {
            HashNode<K, V> node = hashIndex.getNode(key);
            if (node == null) return;

            int idx = node.index;
            int lastIdx = randomIndex.size() - 1;
            K lastKey = randomIndex.get(lastIdx);

            randomIndex.swapAndRemove(idx);

            if (!key.equals(lastKey)) {
                HashNode<K, V> lastNode = hashIndex.getNode(lastKey);
                lastNode.index = idx;
            }
            hashIndex.remove(key);
        });
    }

    @Override
    public Entry<K, V> getRandom() {
        if (randomIndex.size() == 0) return null;

        int idx = random.nextInt(randomIndex.size());
        K key = randomIndex.get(idx);
        V value = get(key);
        return new Entry<>(key, value);
    }
}


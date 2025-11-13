import java.util.*;

// MyHashMap, my custom map that uses hashing with separate chaining
public class MyHashMap<K, V> implements MyMap<K, V> {
    // default values
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    private static int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity = DEFAULT_INITIAL_CAPACITY;
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    private float loadFactorThreshold = DEFAULT_MAX_LOAD_FACTOR;
    private int size = 0;
    private LinkedList<MyMap.Entry<K, V>>[] table;

    // create a default map
    public MyHashMap() {
        table = new LinkedList[capacity];
    }

    // create a map with specific capacity
    public MyHashMap(int initialCapacity) {
        capacity = initialCapacity;
        table = new LinkedList[capacity];
    }

    // create a map with capacity and load factor
    public MyHashMap(int initialCapacity, float loadFactorThreshold) {
        this.loadFactorThreshold = loadFactorThreshold;
        capacity = initialCapacity;
        table = new LinkedList[capacity];
    }

    // remove all entries
    public void clear() {
        size = 0;
        removeEntries();
    }

    // check if key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // check if value exists
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                for (Entry<K, V> entry : table[i])
                    if (entry.getValue().equals(value))
                        return true;
        }
        return false;
    }

    // return all entries
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                set.addAll(table[i]);
        }
        return set;
    }

    // get value by key
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            for (Entry<K, V> entry : table[bucketIndex])
                if (entry.getKey().equals(key))
                    return entry.getValue();
        }
        return null;
    }

    // true if map empty
    public boolean isEmpty() {
        return size == 0;
    }

    // return all keys
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                for (Entry<K, V> entry : table[i])
                    set.add(entry.getKey());
        }
        return set;
    }

    // add or replace key-value pair
    public V put(K key, V value) {
        if (get(key) != null) {
            int bucketIndex = hash(key.hashCode());
            for (Entry<K, V> entry : table[bucketIndex])
                if (entry.getKey().equals(key)) {
                    V old = entry.getValue();
                    entry.value = value;
                    return old;
                }
        }

        if (size >= capacity * loadFactorThreshold)
            if (capacity <= MAXIMUM_CAPACITY)
                rehash();

        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] == null)
            table[bucketIndex] = new LinkedList<>();

        table[bucketIndex].add(new Entry<>(key, value));
        size++;
        return value;
    }

    // remove by key
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null)
            for (Entry<K, V> entry : table[bucketIndex])
                if (entry.getKey().equals(key)) {
                    table[bucketIndex].remove(entry);
                    size--;
                    break;
                }
    }

    // return number of entries
    public int size() {
        return size;
    }

    // return all values
    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                for (Entry<K, V> entry : table[i])
                    set.add(entry.getValue());
        }
        return set;
    }

    // hash the key
    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    // make hash more random
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // rehash when load too big
    private void rehash() {
        Set<Entry<K, V>> set = entrySet();
        capacity <<= 1;
        table = new LinkedList[capacity];
        size = 0;
        for (Entry<K, V> entry : set)
            put(entry.getKey(), entry.getValue());
    }

    // remove all bucket entries
    private void removeEntries() {
        for (int i = 0; i < capacity; i++)
            if (table[i] != null)
                table[i].clear();
    }

    // print whole map
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].size() > 0)
                for (Entry<K, V> entry : table[i])
                    sb.append(entry);
        }
        return sb.append("]").toString();
    }
}
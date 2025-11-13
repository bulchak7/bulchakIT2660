public interface MyMap<K, V> {

    // returns number of entries
    public int size();

    // true if map is empty
    public boolean isEmpty();

    // true if this key exists
    public boolean containsKey(K key);

    // true if this value exists
    public boolean containsValue(V value);

    // get the value for a key
    public V get(K key);

    // add a new key-value pair
    public V put(K key, V value);

    // remove key and its value
    public void remove(K key);

    // clear the map
    public void clear();

    // return all keys
    public java.util.Set<K> keySet();

    // return all values
    public java.util.Set<V> values();

    // return all entries (key-value pairs)
    public java.util.Set<Entry<K, V>> entrySet();

    // Entry class, represents one key-value pair
    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // return key
        public K getKey() {
            return key;
        }

        // return value
        public V getValue() {
            return value;
        }

        // print entry
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }
}

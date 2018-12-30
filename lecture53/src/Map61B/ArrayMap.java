package Map61B;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert.*;
import java.util.Iterator;

public class ArrayMap<K, V> implements Iterable<K> {
    public class KeyIterator implements Iterator<K> {
        private int wizardPosition;

        public KeyIterator() {
            wizardPosition = 0;
        }

        public boolean hasNext() {
            return size > wizardPosition;
        }

        public K next() {
            return keys[wizardPosition++];
        }
    }

    public Iterator<K> iterator() {
        return new KeyIterator();
    }

    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key))
                return i;
        }
        return -1;
    }

    public boolean containsKey(K key) {
        return keyIndex(key) != -1;
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
            return;
        }
        values[index] = value;
    }

    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1)
            return null;
        return values[index];
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++)
            keyList.add(keys[i]);
        return keyList;
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
    }
}

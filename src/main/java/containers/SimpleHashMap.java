package containers;

import java.util.*;

/**
 * Created by yuez on 14-1-13.
 * A demonstration hashed map
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;

    LinkedList<SimpleEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<SimpleEntry<K, V>>();
        LinkedList<SimpleEntry<K, V>> bucket = buckets[index];
        SimpleEntry<K, V> pair = new SimpleEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<SimpleEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            SimpleEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (SimpleEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for (LinkedList<SimpleEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (SimpleEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
}

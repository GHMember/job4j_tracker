package ru.job4j.cache;

import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) {
        return cache.containsKey(key) ? cache.get(key).get() : null;
    }

    protected abstract V load(K key) throws FileNotFoundException;

}
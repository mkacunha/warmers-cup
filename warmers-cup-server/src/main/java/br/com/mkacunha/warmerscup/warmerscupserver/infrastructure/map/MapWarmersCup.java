package br.com.mkacunha.warmerscup.warmerscupserver.infrastructure.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MapWarmersCup<K, V> {

    private Map<K, V> map = new HashMap<>();

    public V putIfNotPresent(K key, Supplier<V> value) {
        if (this.map.containsKey(key)) {
            return this.map.get(key);
        }
        return this.put(key, value.get());
    }

    public V put(K key, V value) {
        this.map.put(key, value);
        return value;
    }

    public Collection<V> values(){
        return this.map.values();
    }
}
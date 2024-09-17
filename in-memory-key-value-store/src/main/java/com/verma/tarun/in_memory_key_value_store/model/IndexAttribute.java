package com.verma.tarun.in_memory_key_value_store.model;

import java.util.HashMap;
import java.util.Map;

public class IndexAttribute {
    private Map<String, AttributeMetadata> map;

    public IndexAttribute() {
        this.map = new HashMap<>();
    }

    public boolean contains(String key) {
        return map.containsKey(key);
    }

    public AttributeType getType(String key) {
        return map.get(key).getType();
    }

    public void put(String key, AttributeMetadata metadata) {
        map.put(key, metadata);
    }

    public void increment(String key) {
        int newCount = map.get(key).getCount() + 1;
        map.get(key).setCount(newCount);
    }

    public void decrement(String key) {
        int newCount = map.get(key).getCount() - 1;
        if (newCount == 0) {
            map.remove(key);
        }
        else {
            map.get(key).setCount(newCount);
        }
    }
}

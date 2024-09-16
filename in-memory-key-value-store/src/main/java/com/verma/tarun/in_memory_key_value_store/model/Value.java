package com.verma.tarun.in_memory_key_value_store.model;

import java.util.HashMap;
import java.util.Map;

public class Value {
    private Map<String, Attribute> map;

    public Value() {
        this.map = new HashMap<>();
    }

    public void put(String key, Attribute value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        map.forEach((k,v) -> {
            builder.append(String.format("%s: %s, ", k, v));
        });
        return builder.toString();
    }

    public boolean hasKeyValuePair(String attributeKey, String attributeValue) {
        return map.containsKey(attributeKey) && map.get(attributeKey).equals(attributeValue);
    }
}

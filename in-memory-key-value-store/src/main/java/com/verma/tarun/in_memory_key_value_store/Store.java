package com.verma.tarun.in_memory_key_value_store;

import com.verma.tarun.in_memory_key_value_store.model.Attribute;
import com.verma.tarun.in_memory_key_value_store.model.Value;
import com.verma.tarun.in_memory_key_value_store.util.AttributeParser;
import com.verma.tarun.in_memory_key_value_store.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Store {
    private Map<String, Value> map;
    private final AttributeParser parser;

    public Store() {
        this.map = new HashMap<>();
        this.parser = new AttributeParser();
    }

    public Value get(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public List<String> search(String attributeKey, String attributeValue) {
        return map.entrySet().stream()
                .filter(k -> k.getValue().hasKeyValuePair(attributeKey, attributeValue))
                .map(Map.Entry::getKey)
                .toList();
    }

    public void put(String key, List<Pair<String, String>> listOfAttributePairs) {
        Value value = new Value();
        listOfAttributePairs.forEach(v -> {
            Attribute attribute = parser.parse(v.getValue());
            value.put(v.getKey(), attribute);
        });
        map.put(key, value);
    }

    public void delete(String key) {
        map.remove(key);
    }

    public List<String> keys() {
        return map.keySet().stream().toList();
    }
}

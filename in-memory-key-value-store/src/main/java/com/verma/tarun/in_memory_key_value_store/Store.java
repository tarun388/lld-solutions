package com.verma.tarun.in_memory_key_value_store;

import com.verma.tarun.in_memory_key_value_store.exception.AttributeTypeMismatch;
import com.verma.tarun.in_memory_key_value_store.model.Attribute;
import com.verma.tarun.in_memory_key_value_store.model.AttributeMetadata;
import com.verma.tarun.in_memory_key_value_store.model.AttributeType;
import com.verma.tarun.in_memory_key_value_store.model.IndexAttribute;
import com.verma.tarun.in_memory_key_value_store.model.Value;
import com.verma.tarun.in_memory_key_value_store.util.AttributeParser;
import com.verma.tarun.in_memory_key_value_store.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Store {
    private Map<String, Value> map;
    private final AttributeParser parser;
    private IndexAttribute indexAttribute;

    public Store() {
        this.map = new HashMap<>();
        this.parser = new AttributeParser();
        this.indexAttribute = new IndexAttribute();
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

    public void put(String key, List<Pair<String, String>> listOfAttributePairs) throws Exception{
        Value value = new Value();
        for (Pair<String, String> v : listOfAttributePairs) {
            validateAttributeKeyValuePairAndUpdateIndex(v.getKey(), v.getValue());

            Attribute attribute = parser.parse(v.getValue());
            value.put(v.getKey(), attribute);
        }
        map.put(key, value);
    }

    public void delete(String key) {
        if (map.containsKey(key)) {
            Value value = get(key);
            Set<String> attributeKeys = value.getKeys();
            attributeKeys.forEach(k -> {
                indexAttribute.decrement(k);
            });
            map.remove(key);
        }
    }

    public List<String> keys() {
        return map.keySet().stream().toList();
    }

    private void validateAttributeKeyValuePairAndUpdateIndex(String key, String value) throws AttributeTypeMismatch {
        AttributeType actualType = parser.getAttributeType(value);
        if (indexAttribute.contains(key)) {
            AttributeType requiredType = indexAttribute.getType(key);
            if (!requiredType.equals(actualType)) {
                throw new AttributeTypeMismatch("Illegal attribute type");
            }
            indexAttribute.increment(key);
        }
        else {
            indexAttribute.put(key, new AttributeMetadata(actualType));
        }
    }
}

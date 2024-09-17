package com.verma.tarun.in_memory_key_value_store.model;

public class AttributeMetadata {
    private final AttributeType type;
    private int count;

    public AttributeMetadata(AttributeType type) {
        this.type = type;
        this.count = 1;
    }

    public AttributeType getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

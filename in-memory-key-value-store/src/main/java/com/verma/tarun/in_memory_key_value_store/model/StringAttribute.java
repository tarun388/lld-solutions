package com.verma.tarun.in_memory_key_value_store.model;

public class StringAttribute implements Attribute {
    private String value;

    public StringAttribute(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(String val) {
        return this.value.equals(val);
    }
}

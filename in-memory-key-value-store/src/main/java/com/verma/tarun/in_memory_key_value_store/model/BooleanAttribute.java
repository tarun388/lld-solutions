package com.verma.tarun.in_memory_key_value_store.model;

public class BooleanAttribute implements Attribute {
    private boolean value;

    public BooleanAttribute(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public boolean equals(String val) {
        try {
            boolean parsedVal = Boolean.parseBoolean(val);
            return this.value == parsedVal;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}

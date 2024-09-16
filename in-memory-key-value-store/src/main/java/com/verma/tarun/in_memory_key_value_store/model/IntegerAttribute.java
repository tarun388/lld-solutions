package com.verma.tarun.in_memory_key_value_store.model;

public class IntegerAttribute implements Attribute {
    private int value;

    public IntegerAttribute(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(String val) {
        try {
            int parsedVal = Integer.parseInt(val);
            return this.value == parsedVal;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}

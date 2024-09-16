package com.verma.tarun.in_memory_key_value_store.model;

public class DoubleAttribute implements Attribute {
    private double value;

    public DoubleAttribute(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(String val) {
        try {
            double parsedVal = Double.parseDouble(val);
            return this.value == parsedVal;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}

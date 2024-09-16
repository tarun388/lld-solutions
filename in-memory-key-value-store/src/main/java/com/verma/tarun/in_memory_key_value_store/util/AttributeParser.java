package com.verma.tarun.in_memory_key_value_store.util;

import com.verma.tarun.in_memory_key_value_store.model.Attribute;
import com.verma.tarun.in_memory_key_value_store.model.BooleanAttribute;
import com.verma.tarun.in_memory_key_value_store.model.DoubleAttribute;
import com.verma.tarun.in_memory_key_value_store.model.IntegerAttribute;
import com.verma.tarun.in_memory_key_value_store.model.StringAttribute;

public class AttributeParser {
    public Attribute parse(String value) {
        if (isInteger(value)) {
            return new IntegerAttribute(Integer.parseInt(value));
        } else if (isDouble(value)) {
            return new DoubleAttribute(Double.parseDouble(value));
        } else if (isBoolean(value)) {
            return new BooleanAttribute(Boolean.parseBoolean(value));
        }
        return new StringAttribute(value);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isBoolean(String value) {
        try {
            Boolean.parseBoolean(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}

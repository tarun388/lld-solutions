package com.verma.tarun.in_memory_key_value_store;

import com.verma.tarun.in_memory_key_value_store.util.Pair;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Store store = new Store();

        store.put("a", List.of(new Pair<>("a", "1")));
        store.put("b", List.of(new Pair<>("a", "2")));

        System.out.println(store.get("a"));
        System.out.println(store.search("a", "1"));
        System.out.println(store.keys());
    }
}

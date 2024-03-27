package com.verma.tarun.my_hash_map;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<Integer, String>(7);
        map.put(1, "hi");
        map.put(2, "hi");
        map.put(3, "hi");
        map.put(4, "hi");
        map.put(5, "hi");
        map.put(6, "hi");
        map.put(7, "hi");
        map.put(8, "hi");
        map.put(9, "hiiiii");

        System.out.println(map.get(9));
    }
}

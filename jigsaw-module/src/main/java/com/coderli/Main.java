package com.coderli;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map1 = Map.of("a", "1", "b", "2");
        Map<String, String> map2 = new HashMap<>();
        map1.entrySet().stream().forEach(entry -> map2.put(entry.getKey(),entry.getValue()));
        System.out.println(map2);
    }
}

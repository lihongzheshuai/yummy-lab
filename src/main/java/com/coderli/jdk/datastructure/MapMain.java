package com.coderli.jdk.datastructure;

import java.util.Map;
import java.util.TreeMap;

public class MapMain {
    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("a",1);
        map.put("e",2);
        map.put("d",3);
        map.put("c",3);
        map.put("b",3);
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()));
    }
}

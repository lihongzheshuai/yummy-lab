package com.coderli;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Test10 {
    public static void main(String[] args) throws ParseException {
        Map<Integer,Integer> map = Map.of(1, 1, 2, 2, 3, 3, 4, 4);
        map.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println(entry.getValue()));
    }

}
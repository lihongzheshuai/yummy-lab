package com.coderli;

public class Main {
    /* 413 */         public static void main(String[] args) {
        int a = 100;
        Integer b = 100;
        Integer c = 100;
        Integer e = 128;
        Integer f = 128;
        Integer d = new Integer(100);
        System.out.println(a == b); // true
        System.out.println(b == c); // true
        System.out.println(b == d); // false
        System.out.println(e == f); // false
    }
}

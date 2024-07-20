package com.coderli.jdk.basic;

public class StringEqualMain {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2); // true

        // 使用new关键字创建字符串
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println(str3 == str4); // false
        System.out.println(str1 == str3); // false

        // 使用intern()方法
        String str5 = str3.intern();
        System.out.println(str1 == str5); // true

        // 编译时常量
        String str6 = "Hel" + "lo";
        System.out.println(str1 == str6); // true

        // 动态创建的字符串
        String part1 = "Hel";
        String part2 = "lo";
        String str7 = part1 + part2;
        System.out.println(str1 == str7); // false
        System.out.println(str1 == str7.intern()); // true
    }
}

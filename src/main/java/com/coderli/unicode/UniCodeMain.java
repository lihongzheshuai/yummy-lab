package com.coderli.unicode;

import java.nio.charset.Charset;


public class UniCodeMain {

    public static void main(String[] args) {
        String text = "屌";//unicode /u5c4c
        byte[] utf8bytes = getBytes(text, "utf8");
        print(utf8bytes);
        byte[] gbkbytes = getBytes(text, "gbk");
        print(gbkbytes);
        byte[] utf16bytes = getBytes(text, "utf16");
        print(utf16bytes);
        System.out.printf("UTF-GBK: " +  new String(utf8bytes, Charset.forName("gbk")));


        System.out.println(text instanceof String);
    }

    private static byte[] getBytes(String text, String charset) {
        return text.getBytes(Charset.forName(charset));
    }

    private static void print(byte[] bytes) {
        for (byte b : bytes) {
            String binaryString = Integer.toBinaryString(b);
            System.out.print(binaryString.substring(binaryString.length() > 8 ? binaryString.length() - 8 : 0, binaryString.length()));
            System.out.print("\t");
            System.out.print(Integer.toHexString(b));
            System.out.print("\t");
        }
        System.out.println();
    }
}

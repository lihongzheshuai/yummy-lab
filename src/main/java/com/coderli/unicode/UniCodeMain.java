package com.coderli.unicode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;


public class UniCodeMain {

    public static void main(String[] args) throws FileNotFoundException {
        String text = "屌么";//unicode \u5c4c\u4e48
        System.out.println(Charset.defaultCharset().name());
        print(text.getBytes());
        byte[] utf8bytes = getBytes(text, "utf8");
        print(utf8bytes);
        byte[] gbkbytes = getBytes(text, "gbk");
        print(gbkbytes);
        byte[] utf16bytes = getBytes(text, "utf16");
        print(utf16bytes);
        byte[] isoBytes = getBytes(text, "iso-8859-1");
        print(isoBytes);
        System.out.println("UTF8-GBK: " + new String(utf8bytes, Charset.forName("gbk")));
        System.out.println("UTF16-GBK: " + new String(utf16bytes, Charset.forName("gbk")));
        System.out.println("GBK-UTF8: " + new String(gbkbytes, Charset.forName("utf8")));
        System.out.println("GBK-UTF16: " + new String(gbkbytes, Charset.forName("utf16")));
        System.out.println("GBK-ISO: " + new String(gbkbytes, Charset.forName("iso-8859-1")));
        System.out.println("ISO-GBK: " + new String(isoBytes, Charset.forName("gbk")));
        printChar(text);

        System.out.println("Unicode 增补码。");
        char[] c = Character.toChars(Integer.parseInt("1D306", 16));//1D306是一个辅助平面字符
        System.out.println(Character.codePointAt(c, 0));//输出119558，这个是1D306对应的10进制值
        System.out.println(Character.codePointAt(c, 1));//输出57094，这个是c[1]对应字符的10进制值
        System.out.println(new String(c));
        System.out.println("中".length());
    }

    private static void printChar(String text) {
        System.out.println("char length: " + text.length());
        byte[] unicodeBytes = text.getBytes(Charset.forName("unicode"));
        print(unicodeBytes);
        char[] chars = text.toCharArray();
        for (char c : chars) {
            System.out.print(Integer.toBinaryString(c) + " ");
        }
        System.out.println();
    }

    class A implements Runnable {
        @Override
        public void run() {

        }
    }

    private static byte[] getBytes(String text, String charset) {
        return text.getBytes(Charset.forName(charset));
    }

    private static void print(byte[] bytes) {
        for (byte b : bytes) {
            String binaryString = Integer.toBinaryString(b);
            System.out.print(binaryString.substring(binaryString.length() > 8 ? binaryString.length() - 8 : 0, binaryString.length()));
            System.out.print("\t");
        }
        System.out.println("Finish binary bytes print.");
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b));
            System.out.print("\t");
        }
        System.out.println();
    }

}

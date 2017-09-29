package com.coderli.jdk.basic;

import java.io.File;
import java.net.*;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

public class Main {

    public Main() {
        System.out.println(name());
    }

    private String name = "main";
    public String name() {
        return name;
    }

    static class Sub extends Main {
        private String name = "sub";
        public String name() {
            return name;
        }
    }

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
        System.out.println(System.currentTimeMillis());
        System.out.println(instant.getLong(ChronoField.MILLI_OF_SECOND));
    }

}

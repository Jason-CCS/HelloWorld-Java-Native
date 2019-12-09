package com.jason;

import java.util.function.Function;

public class Foo {
    public static void main(String[] args) {
        new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return null;
            }
        };

    }
}

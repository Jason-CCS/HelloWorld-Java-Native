package com.jason;

import java.util.function.Function;

public class SwapNumber {

    public static void swap(Integer a, Integer b) {
        Integer tmp = 0;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void swapString(String a, String b) {
        String tmp = a;
        a = b;
        b = tmp;
    }

    public static void main(String[] args) {
        Integer input = 1;
        Integer output = 100;
        System.out.println("---before---");
        System.out.println("input: " + input + ", output: " + output);

        System.out.println("---after---");
        swap(input, output);
        System.out.println("input: " + input + ", output: " + output);

        String strA = "1";
        String strB = "100";
        System.out.println("---before---");
        System.out.println("input: " + strA + ", output: " + strB);

        System.out.println("---after---");
        swapString(strA, strB);
        System.out.println("input: " + strA + ", output: " + strB);

    }
}
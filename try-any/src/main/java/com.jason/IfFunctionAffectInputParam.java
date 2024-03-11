package com.jason;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IfFunctionAffectInputParam {

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

    public static void try1(int[] array){
        array[0]=1000;
    }

    public static void try2(int[] array){
        array = new int[]{10, 10, 10};
    }

    public static void try3(List<Integer> list){
        list = new ArrayList<>();
    }

    public static void main(String[] args) {
        Integer input = 1;
        Integer output = 100;
        swap(input, output);
        System.out.println("input: " + input + ", output: " + output);

        String strA = "1";
        String strB = "100";
        swapString(strA, strB);
        System.out.println("input: " + strA + ", output: " + strB);

        int[] nums = {1, 2, 3};
        try1(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {1, 2, 3};
        try2(nums2);
        System.out.println(Arrays.toString(nums2));

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        try3(list);
        System.out.println(list);
    }
}
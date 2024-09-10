package com.jason.hack_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] countAry = new int[100];
        for (int i : arr) {
            countAry[i]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < countAry.length; i++) {
            result.add(countAry[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countingSort(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }
}

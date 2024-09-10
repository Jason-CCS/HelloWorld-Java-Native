package com.jason.hack_rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedian {

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int n = arr.size() / 2;
        Collections.sort(arr);
        return arr.get(n);
    }

    public static void main(String[] args) {
        System.out.println(findMedian(Arrays.asList(0, 1, 2, 4, 6, 5, 3)));
    }
}

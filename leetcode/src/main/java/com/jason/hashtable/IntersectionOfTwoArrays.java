package com.jason.hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Problem: 349
 * Topic: Hashtable
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (Integer i : nums1) hashSet.add(i);
        for (Integer j : nums2) {
            if (hashSet.contains(j))
                resultSet.add(j);
        }
        int[] result = new int[resultSet.size()];
        int idx=0;
        for (Integer e: resultSet){
            result[idx]=e;
            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection1(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection1(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}

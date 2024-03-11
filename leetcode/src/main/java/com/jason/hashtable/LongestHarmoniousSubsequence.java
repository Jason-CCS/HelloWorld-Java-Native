package com.jason.hashtable;

import java.util.Collections;
import java.util.HashMap;

/**
 * Problem: 594
 * Topic: HashTable
 */
public class LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (Integer i : nums) {
            if (!hashMap.containsKey(i))
                hashMap.put(i, 1);
            else
                hashMap.put(i, hashMap.get(i) + 1);
        }
        int max = 0;
        for (Integer j : hashMap.keySet()) {
            if (hashMap.containsKey(j + 1))
                max = Math.max(max, hashMap.get(j) + hashMap.get(j + 1));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] tc1 = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] tc2 = {1, 2, 3, 4};
        int[] tc3 = {1, 1, 1, 1};


        System.out.println(findLHS(tc1));
        System.out.println(findLHS(tc2));
        System.out.println(findLHS(tc3));
    }
}

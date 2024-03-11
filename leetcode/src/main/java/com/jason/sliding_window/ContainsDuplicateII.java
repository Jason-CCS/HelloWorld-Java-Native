package com.jason.sliding_window;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Problem: 219
 * Difficulty: Easy
 */
public class ContainsDuplicateII {

    /**
     * First Version.
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (i-hashMap.get(nums[i])<=k)
                    return true;
                else
                    hashMap.put(nums[i], i);
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] tc1 = {1,2,3,1};
        int[] tc2 = {1,0,1,1};
        int[] tc3 = {1,2,3,1,2,3};

        System.out.println(containsNearbyDuplicate(tc1, 3));
        System.out.println(containsNearbyDuplicate(tc2, 1));
        System.out.println(containsNearbyDuplicate(tc3, 2));
    }
}

package com.jason.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The key to use HashTable is if you want O(1) time complexity to get the value by key.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer comp;
        for (int i = 0; i < nums.length; i++) {
            comp=map.get(target - nums[i]);
            if (null != comp) {
                return new int[]{comp, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}

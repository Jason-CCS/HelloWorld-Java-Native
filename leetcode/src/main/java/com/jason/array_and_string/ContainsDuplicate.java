package com.jason.array_and_string;

import java.util.HashSet;

/**
 * Problem: 217
 * Difficulty: Easy
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    /**
     * This way will lead to the size of array is not enough.
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            if (counts[num - min] == 1) return true;
            counts[num - min]++;
        }
        return false;
    }
}

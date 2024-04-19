package com.jason.sort_and_search;

import java.util.Arrays;

/**
 * Problem number: 167
 * Difficulty: Medium
 * Problem description: Determine two indices in a sorted array such that the corresponding numbers sum up to a defined target.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int complement = target - numbers[i];
            int j = enhancedBinarySearch(numbers, i, complement);
            if (j != -1)
                return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    public int enhancedBinarySearch(int[] nums, int startIdx, int target) {
        int l = startIdx, r = nums.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                if (nums[m] == target) {
                    return m;
                } else {
                    r = m;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII().twoSum(new int[]{-10, -5, 0,0,3,4}, 0)));
    }
}

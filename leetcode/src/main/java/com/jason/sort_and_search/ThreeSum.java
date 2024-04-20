package com.jason.sort_and_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 15
 * Difficulty: Medium
 * Problem Description: Given an array of integers, the objective is to find all unique triplets in the array which sum adds up to zero.
 */
public class ThreeSum {
    /**
     * Time Complexity: O(n^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicate nums[left]
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate nums[right]
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 1, 1}));
        System.out.println(new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}

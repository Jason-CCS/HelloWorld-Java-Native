package com.jason.sliding_window;

/**
 * Problem: 209
 * Difficulty: Medium
 * Problem Description: Determine the minimal length of a contiguous subarray of which the sum is at least equal to a given target number.
 */
public class MinimumSizeSubarraySum {
    /**
     * Time Complexity is O(n).
     * Here's why:
     * Even though there's a loop within a loop, you're not performing an operation for each pair of elements.
     * Each element in nums array is processed exactly twice - once when it is added to the sum (in the outer loop),
     * and once when it is removed from the sum (in the inner loop).
     * Therefore, the time complexity is O(2n), which simplifies to O(n).
     * This makes the sliding window approach efficient for this problem.
     * The space complexity of this solution is O(1).
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                if (minLength == 1) return 1;
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

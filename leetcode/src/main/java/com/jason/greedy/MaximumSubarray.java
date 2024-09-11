package com.jason.greedy;

/**
 * Problem: 53
 * Difficulty: Medium
 */
public class MaximumSubarray {

    /**
     * Wrong solution by me.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int left = 0, maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            if (curSum > maxSum) {
                maxSum = curSum;
            } else {
                int oldSum = curSum;
                while (curSum <= oldSum && left < right) {
                    curSum -= nums[left];
                    left++;
//                    maxSum = Math.max(maxSum, curSum);
                }
            }
        }

        return maxSum;
    }

    /**
     * This is a special problem.
     * I don't know the  Kadane's Algorithm. Looks like he found the pattern, and it will always be true even the array consists of all minus number.
     * All the way from the beginning the sum has lead to the minus, it is impossible that you think adding more nums will find bigger maximum.
     * Starting from the number that gives you a positive sum is better.
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{1}));
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-5, -4, -3, -2, -1}));
    }
}

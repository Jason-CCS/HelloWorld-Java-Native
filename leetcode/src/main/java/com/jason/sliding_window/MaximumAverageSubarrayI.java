package com.jason.sliding_window;

/**
 * Problem: 643
 * Difficulty: Easy
 */
public class MaximumAverageSubarrayI {

    /**
     * First Version.
     * Bad Solution: recalculate the result that you have done before.
     * Time Complexity: O(n*k)
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage1(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i + k <= nums.length) {
                int sum = 0;
                for (int j = i; j < i + k; j++) {
                    sum += nums[j];
                }
                maxAverage = Math.max(maxAverage, ((double) sum) / k);
            } else {
                break;
            }
        }

        return maxAverage;
    }

    /**
     * Second Version.
     * So much better than first version. Using dp technique to save the previous calculated sum.
     * Time Complexity: O(n)
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage2(int[] nums, int k) {
        int dpSum = 0;
        for (int i = 0; i < k; i++) {
            dpSum += nums[i];
        }

        int max = dpSum;
        for (int i = k; i < nums.length; i++) {
            dpSum = dpSum - nums[i - k] + nums[i];
            max = Math.max(max, dpSum);
        }

        return (double) max / k;
    }

    public static void main(String[] args) {
        int[] tc1 = {1, 12, -5, -6, 50, 3};
        int[] tc2 = {5};
        int[] tc3 = {-1};


        System.out.println(findMaxAverage2(tc1, 4));
        System.out.println(findMaxAverage2(tc2, 1));
        System.out.println(findMaxAverage2(tc3, 1));
    }
}

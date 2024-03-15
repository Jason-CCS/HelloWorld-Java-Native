package com.jason.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * Problem: 198
 * Difficulty: Medium
 */
public class HouseRobber {

    /**
     * int[] max is the DP part.
     * I use the bottom-up approach. Declare an int[] max array to save the max amount that you can steal at this index.
     * If you start from different path and the amount you steal is greater than max[i], then you can update the records,
     * and you are welcome to keep update the following records.
     * This means other arriver at this point if you have smaller stolen money, it means you don't have to go deeper.
     * It is wasting time, because you won't make greater records.
     *
     * The sub-problem here is at each index you have two ways to go, +2 or +3, and you have to compare them and return bigger.
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int theMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > theMax) {
                theMax = nums[i];
            }
        }
        if (theMax == 0) return 0;

        int[] max = new int[nums.length];

        // start from 0
        int startFromZeroSum = nextRobPlace(nums, 0, 0, max);

        // start from 1
        int startFromOneSum = nextRobPlace(nums, 1, 0, max);

        return Math.max(startFromOneSum, startFromZeroSum);
    }

    public static int nextRobPlace(int[] nums, int currentIndex, int sum, int[] max) {
        // enter this point
        if (currentIndex < nums.length) {
            sum += nums[currentIndex];

            // the sum you have stolen till now if not bigger than history record, then you don't have to go deeper.
            if (max[currentIndex] == 0 || sum > max[currentIndex]) {
                max[currentIndex] = sum;
                // you have two choices to go
                // one way +2 stop
                int twoStepSum = 0, threeStepSum = 0;
                twoStepSum = nextRobPlace(nums, currentIndex + 2, sum, max);

                // one way +3 stop
                threeStepSum = nextRobPlace(nums, currentIndex + 3, sum, max);

                // choose one
                sum = Math.max(twoStepSum, threeStepSum);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9}));
//        System.out.println(rob(new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124}));
    }
}

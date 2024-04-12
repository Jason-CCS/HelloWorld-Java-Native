package com.jason.dp;

/**
 * Problem: 45
 * Difficulty: Medium
 */
public class JumpGameII {

    /**
     * This method calculates the minimal number of jumps to reach the end of a given array.
     * Each integer in the array represents the maximum number of steps that can be made forward from that element.
     * Time Complexity: O(n), where n is the length of the input array 'nums'.
     *
     * @param nums The input array containing non-negative integers.
     * @return The minimum number of jumps from the first position to the last in nums.
     */
    public int jump1(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int steps = 0;
        int currentMaxDistance = 0;
        int nextMaxDistance = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxDistance = Math.max(nextMaxDistance, i + nums[i]);

            if (i == currentMaxDistance) {
                steps++;
                currentMaxDistance = nextMaxDistance;

                if (currentMaxDistance >= nums.length - 1) {
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump1(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameII().jump1(new int[]{2, 3, 0, 1, 4}));
        System.out.println(new JumpGameII().jump1(new int[]{2, 0}));
        System.out.println(new JumpGameII().jump1(new int[]{9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5}));
    }
}

package com.jason.greedy;

/**
 * Problem: 55
 * Difficulty: Medium
 * This problem calculates whether you can reach the end of given array.
 */
public class JumpGameI {
    /**
     * Version 1: my own solution.
     * The provided code is a Solution to the Jump Game problem using depth-first search (DFS) approach.
     * This approach checks every possible jump from each position, which results in a worst-case time complexity of O(n^2) (quadratic).
     * Time Complexity: O(n^2)
     * <br>
     * If we have the n-length array like this: [n-2, n-3, n-4, ..., 0, x],
     * then we will never reach the last index n-1.
     * In this case, for each element in the iteration we should visit all other element at least in the worst case.
     * This leads to the number of recursive call totally are (n-2)+(n-3)+...+1 = O(n^2).
     * Therefore, the time complexity is O(n^2).
     *
     * @param nums an array of non-negative integers, where nums[i] represents the maximum number of steps
     *             that can be jumped from position i
     * @return true if it is possible to reach the last index, false otherwise
     */
    public static boolean canJump1(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        return jumpToPosition(0, nums, visited);
    }

    private static boolean jumpToPosition(int position, int[] nums, boolean[] visited) {
        if (position > nums.length - 1 || visited[position])
            return false;
        else {
            visited[position] = true;
            if (position == nums.length - 1) {
                return true;
            } else {
                for (int i = nums[position]; i >= 1; i--) {
                    if (position + i <= nums.length - 1 && !visited[position + i]) {
                        boolean res = jumpToPosition(position + i, nums, visited);
                        if (res)
                            return true;
                    }
                }
                return false;
            }
        }
    }

    /**
     * Version 2
     * Determines whether it is possible to reach the last index of an array by jumping through positions.
     * This method uses the greedy approach to solve the Jump Game problem.
     * Time Complexity: O(n)
     *
     * @param nums an array of non-negative integers, where nums[i] represents the maximum number of steps
     *             that can be jumped from position i
     * @return true if it is possible to reach the last index, false otherwise
     */
    public static boolean canJump2(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach)
                return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{2, 3, 1, 0, 4}));
        System.out.println(canJump1(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump1(new int[]{2, 0}));
    }
}

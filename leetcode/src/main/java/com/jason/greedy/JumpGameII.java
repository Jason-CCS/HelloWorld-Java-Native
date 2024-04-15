package com.jason.greedy;

/**
 * Problem: 45
 * Difficulty: Medium
 * The JumpGameII class calculates the minimal number of jumps to reach the end of a given array.
 * <p>
 * Greedy algorithms follow a simple problem-solving heuristic which is to make the choice that
 * looks best at the current moment, with the hope that by choosing the best option now, you’ll get
 * an overall optimal solution to the problem.
 * <p>
 * Characteristics of Greedy Algorithms
 * <p>
 * 1. Greedy choice property: A global optimum can be arrived at by selecting a local optimum.
 * 2. Optimal substructure: A problem exhibits optimal substructure if an optimal solution to
 * the problem contains an optimal solution to subproblems.
 */
public class JumpGameII {

    /**
     * The key here is it uses two variables to save the latest greedy value.
     * One is nextMaxDistance, the other is currentMaxDistance.
     * When i reaches currentMaxDistance, it means it reaches last time the most max distance where we can reach.
     * And once we reach, we will see what is the next max distance that we can go.
     * The next max distance might be updated by any of the former index of the current index, so this means the better
     * way to go further is from that former index, but not from the current index.
     * <br>
     * Anyway, using two variables to save the latest greedy values is the way that I have never thought of.
     * Time Complexity: O(n), where n is the length of the input array 'nums'.
     *
     * @param nums The input array containing non-negative integers.
     * @return The minimum number of jumps from the first position to the last in nums.
     */
    public int jump(int[] nums) {
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
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(new JumpGameII().jump(new int[]{2, 0}));
        System.out.println(new JumpGameII().jump(new int[]{9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5}));
    }
}

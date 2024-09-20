package com.jason.dp;

/**
 * Problem: 746
 * Difficulty: Easy
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * Pseudo Code and explanation.
         * Example: [10,15,20]
         * result = min(oneStepCostSum, twoStepCostSum)
         *
         * i = current index, cost[] is the cost array.
         *
         * minSumCost(i, cost[]) => minSum:
         *   if(i>=cost.length) return 0;
         *   if(dp[i]!=0) return dp[i]
         *
         *   dp[i] = cost[i] + min(minSumCost(i+1, cost), minSumCost(i+2, cost));
         *   return dp[i];
         *
         *   i=0, dp[0] = minSum = cost[0] + min(helper(1), helper(2)) = cost[0] + min(15, 20) = 10 + 15 = 25;
         *      i=1, dp[1] = minSum = cost[1] + min(helper(2), helper(3)) = 15+ min(20, 0) = 15;
         *      i=2, dp[2] = minSum = cost[2] + min(helper(3), helper(4)) = 20 + 0;
         *   i=1, dp[1] = minSum = cost[1] + min(helper(2), helper(3)) = 15 + min(20, 0) = 15;
         */
        int[] dp = new int[cost.length];
        return Math.min(minSumCost(0, cost, dp), minSumCost(1, cost, dp));
    }

    /**
     * Time complexity is O(n):
     * We traverse all the stairs once when minSumCost(i+1, cost, dp),
     * and later on all the same sub-problem will get the value from dp[] only.
     * Space complexity is O(n):
     * We allocate n-sized dp array, and the deepest function call is deep to nth level stack.
     * So the space complexity is O(n) too.
     * @param i
     * @param cost
     * @param dp
     * @return
     */
    public int minSumCost(int i, int[] cost, int[] dp) {
        if (i >= cost.length) return 0;
        if (dp[i] != 0) {
            return dp[i];
        } else {
            dp[i] = cost[i] + Math.min(minSumCost(i + 1, cost, dp), minSumCost(i + 2, cost, dp));
        }

        return dp[i];
    }
}

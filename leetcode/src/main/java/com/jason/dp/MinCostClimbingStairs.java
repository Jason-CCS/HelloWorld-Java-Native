package com.jason.dp;

/**
 * Problem: 746
 * Difficulty: Easy
 * The problem is intended to find the minimum cost to climb a set of stairs where each step has a cost, and next step
 * you can choose one step or two step jump.
 */
public class MinCostClimbingStairs {
    /**
     * Pseudo Code and explanation.
     * Example: [10,15,20]
     * Approach:
     * result = min(oneStepCostSum, twoStepCostSum)
     * <p>
     * i = current index, cost[] is the cost array.
     * <p>
     * minSumCost(i, cost[]) => minSum:
     * if(i>=cost.length) return 0;
     * if(dp[i]!=0) return dp[i]
     * <p>
     * dp[i] = cost[i] + min(minSumCost(i+1, cost), minSumCost(i+2, cost));
     * return dp[i];
     * <p>
     * Dry Run:
     * i=0, dp[0] = minSum = cost[0] + min(helper(1), helper(2)) = cost[0] + min(15, 20) = 10 + 15 = 25;
     * i=1, dp[1] = minSum = cost[1] + min(helper(2), helper(3)) = 15+ min(20, 0) = 15;
     * i=2, dp[2] = minSum = cost[2] + min(helper(3), helper(4)) = 20 + 0;
     * i=1, dp[1] = minSum = cost[1] + min(helper(2), helper(3)) = 15 + min(20, 0) = 15;
     */
    public int minCostClimbingStairs(int[] cost) {
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
     *
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

    /**
     * Example: [10,15,20]<br>
     * Approach: Greedy, minSum(i) = min(minSum(i-1)+cost[i-1], minSum(i-2)+cost[i-2])<br>
     * Pseudocode:<br>
     * base case: minSum(0)=0, minSum(1)=0<br>
     * if cost.length <= 2:
     *   return 0;
     *
     * when you are at the i stair, you are only either from the last step or the last two step.<br>
     * so you can simply compare them by min(the cost from the last step, the cost from the last two step).<br>
     * declare p1=minSum(1)=0, p2=minSum(0)=0 // p1 is the cost from the last step, and p2 is the cost from the last two steps.<br>
     *
     * for i=2 till n:
     *   minSum = min(p1+cost[i-1], p2+cost[i-2])
     *   p2 = p1
     *   p1 = minSum
     * end
     *
     * Dry Run:
     * i=2, minSum=min(0+15, 0+10)=10, p2=0, p1=10
     * i=3, minSum=min(10+20, 0+15)=15, p2=10, p1=15
     * return minSum(3)=15;
     */
    public int minCostClimbingStairs2(int[] cost) {

        int p1 = 0;
        int p2 = 0;
        int minSum = 0;
        for (int i = 2; i <= cost.length; i++) {
            minSum = Math.min(p1 + cost[i - 1], p2 + cost[i - 2]);
            p2 = p1;
            p1 = minSum;
        }
        return minSum;
    }
}

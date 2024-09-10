package com.jason.dp;

/**
 * Problem: 309
 * Difficulty: Medium
 * The problem in the current editor focuses on determining the maximum profit obtainable
 * from buying and selling stocks given a cooldown period of one day after selling.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int[] maxProfits = new int[prices.length];

        profitTraverse(prices, 0, 0, maxProfits);

        int maxProfit = Integer.MIN_VALUE;
        for (int profit : maxProfits) {
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    /**
     * This approach is TLE. O(n^2)
     * @param prices
     * @param curIdx
     * @param curSum
     * @param maxProfits
     */
    public void profitTraverse(int[] prices, int curIdx, int curSum, int[] maxProfits) {
        for (int buyIdx = curIdx; buyIdx < prices.length - 1; buyIdx++) { // branch
            int buyPrice = prices[buyIdx];
            for (int sellIdx = buyIdx + 1; sellIdx < prices.length; sellIdx++) { // branch
                int newSum = curSum + (prices[sellIdx] - buyPrice);
                // bound
                if (newSum > maxProfits[sellIdx]) { // if better than record, keep buying, otherwise try next sellIdx.
                    maxProfits[sellIdx] = newSum;
                    profitTraverse(prices, sellIdx + 2, newSum, maxProfits);
                }
            }
        }
    }

    /**
     * This solution is from AI.
     * Key Point: Understanding how the state change from previous to current is so important.
     * This approach basically just write the logic of state change and then solve the problem. So simple.
     * The state here is three variables: sold, hold, and rest profits.
     * You can see them as DP. (The previous max profit.)
     * O(n)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        if (prices.length <= 1) return 0;

        int sold = 0, hold = -prices[0], rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prev_sold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prev_sold);
        }

        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(solution.maxProfit(new int[]{1,2,3,0,2}));
    }
}

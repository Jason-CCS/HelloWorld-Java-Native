package com.jason.dynamic_programming;

/**
 * Star Five.
 * This solution is from the discussion with the colleagues.
 * This is really the good solution if you encounter the same scenario.
 * The price is going up and down.
 * The sum of every small interval(prices[i+1]>prices[i]) transactions is greater than a few times of max profit transactions.
 */
public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i + 1] > prices[i]) {
                maxProfit = maxProfit + (prices[i + 1] - prices[i]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
        int[] prices4 = {7, 2, 5, 3, 4, 6, 1, 9};

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
        System.out.println(maxProfit(prices4));
    }
}

package com.jason.dp;

/**
 * Problem 121.
 * This solution is especially for this problem.
 * Since we can only sell the stock later than the stock you buy,
 * so we can get the min by update from line 17.
 * And only update the maxProfit for those future prices is greater than min.
 * Finally, we will have the maxProfit.
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for (int price : prices) {
            int profit = price - min;
            if (profit > 0 && profit > maxProfit) {
                maxProfit = profit;
            } else if (profit < 0) {
                min = price;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        int[] prices2={7,6,4,3,1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
    }
}

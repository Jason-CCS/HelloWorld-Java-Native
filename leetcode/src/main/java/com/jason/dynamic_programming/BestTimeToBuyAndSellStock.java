package com.jason.dynamic_programming;

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

package com.jason;

import java.util.ArrayList;
import java.util.List;

public class HyTech {
    public static int calMaxProfit(int[] priceAry) {
        int maxProfit = 0;
        for (int i = 1; i < priceAry.length; i++) {
            for (int j = 0; j < i; j++) {
                if (priceAry[i] - priceAry[j] > maxProfit) {
                    maxProfit = priceAry[i] - priceAry[j];
                }
            }
        }

        return maxProfit;
    }

    /**
     * Time complexity is O(n*k) k is the count of prime number less than n.
     * @param n
     * @return
     */
    public static int primeCount(int n) {
        List<Integer> primeList = new ArrayList<>();
        boolean flag = true;
        if (n < 2) return 0;
        for (int i = 2; i <= n; i++) {
            for (Integer e : primeList) {
                if (i % e == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeList.add(i);
            } else {
                flag = true;
            }
        }

        return primeList.size();
    }

    public static void main(String[] args) {
        System.out.println(calMaxProfit(new int[]{10, 10, 10, 10, 10, 10, 30, 10, 19, 55, 4, 8, 50}));

        System.out.println(primeCount(100));
    }
}

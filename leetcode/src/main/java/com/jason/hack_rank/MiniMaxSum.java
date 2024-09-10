package com.jason.hack_rank;

import java.math.BigInteger;
import java.util.List;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        BigInteger sum = new BigInteger("0");
        for (Integer i : arr) {
            sum = sum.add(BigInteger.valueOf(i));
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }

        System.out.println((sum.add(BigInteger.valueOf(-max))) + " " + sum.add(BigInteger.valueOf(-min)));
    }
}

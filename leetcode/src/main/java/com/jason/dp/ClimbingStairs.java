package com.jason.dp;

/**
 * This is the variant of Fibonacci sequence.
 * Good to practice the Dynamic Programming.
 * Dynamic Programming is using the cache to remember what you had calculated before.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return fibonacciLike(n, new int[n + 1]);
    }

    public int fibonacciLike(int n, int[] cache) {
        if (n <= 2) {
            return n;
        }
        if (cache[n] == 0) {
            cache[n] = fibonacciLike(n - 1, cache) + fibonacciLike(n - 2, cache);
        }
        return cache[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(0));
        System.out.println(cs.climbStairs(1));
        System.out.println(cs.climbStairs(2));
        System.out.println(cs.climbStairs(3));
        System.out.println(cs.climbStairs(4));
        System.out.println(cs.climbStairs(5));
        System.out.println(cs.climbStairs(6));
        System.out.println(cs.climbStairs(7));
        System.out.println(cs.climbStairs(45));
    }
}

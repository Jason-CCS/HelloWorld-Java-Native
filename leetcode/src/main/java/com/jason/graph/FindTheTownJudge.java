package com.jason.graph;

import java.util.*;

/**
 * Problem: 997
 * Difficulty: Easy
 */
public class FindTheTownJudge {

    /**
     * The first version.
     * My solution is very the same as the solutions given in the LeetCode Solutions section.
     * We all use an array to store the trust counter.
     * @param n
     * @param trust
     * @return
     */
    public static int findJudge(int n, int[][] trust) {
        int[] counter = new int[n + 1];
        int possibleJudge = 1;
        int maxCount = Integer.MIN_VALUE;
        for (int[] t : trust) {
            counter[t[0]]--;
            counter[t[1]]++;
            if (counter[t[1]] > maxCount) {
                maxCount = counter[t[1]];
                possibleJudge = t[1];
            }
        }

        return (counter[possibleJudge] == n - 1) ? possibleJudge : -1;
    }

    public static void main(String[] args) {
        int[][] tc1 = {{1, 2}};
        int[][] tc2 = {{1, 3}, {2, 3}};
        int[][] tc3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(2, tc1));
        System.out.println(findJudge(3, tc2));
        System.out.println(findJudge(3, tc3));
    }
}

package com.jason.dp;

import java.util.*;

/**
 * Problem: 120
 * Difficulty: Medium
 * The purpose of the problem is to find the path with the least total sum of all numbers from top to bottom
 * in a triangle represented as a two-dimensional list, and return that minimum total.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j < curRow.size(); j++) {
                int min = Math.min(getLastRowValue(lastRow, j - 1), getLastRowValue(lastRow, j));
                curRow.set(j, curRow.get(j) + min);
            }
        }

        return triangle.get(triangle.size() - 1).stream().min(Comparator.naturalOrder()).orElse(0);
    }

    private int getLastRowValue(List<Integer> lastRow, int index) {
        if (index < 0 || index >= lastRow.size()) return Integer.MAX_VALUE;
        return lastRow.get(index);
    }

    public static void main(String[] args) {
        List<List<Integer>> tc1 = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));


        System.out.println(new Triangle().minimumTotal(tc1));
    }
}

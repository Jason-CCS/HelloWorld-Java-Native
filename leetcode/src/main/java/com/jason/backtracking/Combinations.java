package com.jason.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: 77
 * Difficulty: Medium
 * The problem requires generating all possible combinations from a set of integers from 1 to n, where you choose k numbers at a time.
 */
public class Combinations {
    /**
     * This solution can be the standard solution for those problem which needs the combinations.
     * This solution beats 99.6% of users with Java.
     * Time complexity is O(k*nCk).
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>(Collections.nCopies(k, 0));
        helper(0, 1, n - k + 1, k - 1, combination, res);
        return res;
    }

    private void helper(int level, int start, int end, int limit, List<Integer> combination, List<List<Integer>> res) {
        for (int i = start; i <= end; i++) {
            combination.set(level, i);
            if (level == limit)
                res.add(new ArrayList<>(combination));
            else
                helper(level + 1, i + 1, end + 1, limit, combination, res);
        }
    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        System.out.println(solution.combine(5, 3));
    }
}

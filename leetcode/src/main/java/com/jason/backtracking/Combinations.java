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
     * This solution beats 99.59% of users with Java.
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(Collections.nCopies(k, 0));
        combination(1, n - k + 1, 0, k - 1, list, res);
        return res;
    }

    private void combination(int start, int end, int level, int limit, List<Integer> list, List<List<Integer>> res) {
        if (level == limit) {
            for (int i = start; i <= end; i++) {
                list.set(level, i);
                res.add(new ArrayList<>(list));
            }
        } else {
            for (int i = start; i <= end; i++) {
                list.set(level, i);
                combination(i + 1, end + 1, level + 1, limit, list, res);
            }
        }
    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        System.out.println(solution.combine(5, 3));
    }
}

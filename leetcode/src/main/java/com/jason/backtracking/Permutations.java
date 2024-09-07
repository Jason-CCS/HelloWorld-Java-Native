package com.jason.backtracking;

import java.util.*;

/**
 * Problem: 46
 * Difficulty: Medium
 * The problem requires generating all possible permutations of a given array of distinct integers.
 */
public class Permutations {
    /**
     * This solution can be a standard solution for those problem which needs the permutations.
     * Time complexity is O(n^n).
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        helper(0, permutation, res, nums);
        return res;
    }

    /**
     * Guess this is not the best solution, since we can use backtracking to avoid the re-visit the same numer in the for loop.
     * @param level
     * @param permutation
     * @param res
     * @param nums
     */
    private void helper(int level, List<Integer> permutation, List<List<Integer>> res, int[] nums) {
        for (Integer number : nums) {
            if (permutation.contains(number)) continue;
            permutation.add(number);
            if (level == nums.length - 1)
                res.add(new ArrayList<>(permutation));
            else
                helper(level + 1, permutation, res, nums);
            permutation.remove(number);
        }
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();
        System.out.println(sol.permute(new int[]{3, 4, 5}));
//        System.out.println(sol.permute(new int[]{0, 1}));
//        System.out.println(sol.permute(new int[]{1}));
    }
}

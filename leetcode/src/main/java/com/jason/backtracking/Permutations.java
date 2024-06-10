package com.jason.backtracking;

import java.util.*;

/**
 * Problem: 46
 * Difficulty: Medium
 * The problem requires generating all possible permutations of a given array of distinct integers.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        helper(0, indexes, res, nums);
        return res;
    }

    private void helper(int level, List<Integer> indexes, List<List<Integer>> res, int[] nums) {
        if (level == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : indexes) {
                list.add(nums[i]);
            }
            res.add(list);
        } else {
            for (Integer i = 0; i < nums.length; i++) {
                if (indexes.contains(i)) continue;
                indexes.add(i);
                helper(level + 1, indexes, res, nums);
                indexes.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();
        System.out.println(sol.permute(new int[]{1, 2, 3}));
//        System.out.println(sol.permute(new int[]{0, 1}));
        System.out.println(sol.permute(new int[]{1}));
    }
}

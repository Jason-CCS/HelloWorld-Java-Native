package com.jason.array_and_string;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

/**
 * Problem: 189
 * Difficulty: Medium
 * The purpose of this Leetcode problem is to rotate an array to the right by k steps where k is a non-negative integer.
 */
public class RotateArray {
    /**
     * the first version I can think of is using Queue.
     * Queue(k-sized)
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        if (k == 0 || k == n)
            return;
        if (k > n) {
            k = k % n;
        }
        int source, target;
        ArrayDeque<Map.Entry<Integer, Integer>> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            deque.add(new AbstractMap.SimpleEntry<>(i, nums[i])); // please remember how to init an entry.
        }

        while (!deque.isEmpty()) {
            Map.Entry<Integer, Integer> e = deque.poll();
            source = e.getKey();
            if (source + k >= n) {
                target = source + k - n;
                nums[target] = e.getValue();
            } else {
                target = source + k;
                deque.add(new AbstractMap.SimpleEntry<>(target, nums[target]));
                nums[target] = e.getValue();
            }
        }
    }

    /**
     * This version is from leetcode solutions.
     * This is impossible for me to think of this solution unless you keep thinking the outcome pattern for really long time.
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] tc1 = {1, 2, 3, 4, 5, 6, 7};
        rotate2(tc1, 3);
        System.out.println(Arrays.toString(tc1));

        int[] tc2 = {-1, -100, 3, 99};
        rotate2(tc2, 2);
        System.out.println(Arrays.toString(tc2));

        int[] tc3 = {-1};
        rotate2(tc3, 2);
        System.out.println(Arrays.toString(tc3));
    }
}

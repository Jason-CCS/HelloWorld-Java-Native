package com.jason.sort_and_search.binary_search;

/**
 * Problem: 704
 * Difficulty: Easy
 * Key point: right is nums.length, rather than nums.length-1.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // This is really key point. right is nums.length, rather than nums.length-1.

        while (left < right) {
            int m = (left + right) / 2;
            if (nums[m] == target) {
                return m;
            } else {
                if (target < nums[m])
                    right = m;
                else
                    left = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(bs.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(bs.search(new int[]{5}, 5));
        System.out.println(bs.search(new int[]{1}, 2));
        System.out.println(bs.search(new int[]{1, 2}, 2));

    }
}

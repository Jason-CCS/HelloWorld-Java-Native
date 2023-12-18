package com.jason.binary_search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length, m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                if (nums[m] == target) {
                    return m;
                } else {
                    r = m;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(bs.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(bs.search(new int[]{}, 2));
        System.out.println(bs.search(new int[]{1}, 2));
        System.out.println(bs.search(new int[]{1, 2}, 2));

    }
}

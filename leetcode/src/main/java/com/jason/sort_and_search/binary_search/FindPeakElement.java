package com.jason.sort_and_search.binary_search;

/**
 * Problem: 162
 * Difficulty: Medium
 */
public class FindPeakElement {

    /**
     * This version is from LeetCode solutions.
     * I don't even think that the Binary Search can be applied on unsorted array.
     * So it is still possible when portions of array still have the increasing or decreasing trend.
     * Then it is possible.
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;

        /**
         * peak happens in the end of the array
         */
        int n = nums.length;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        /**
         * otherwise, binary search for the peak
         */
        int l = 1, r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] < nums[mid - 1]) r = mid - 1;
            else if (nums[mid] < nums[mid + 1]) l = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tc1 = {3,4,3,2,1};
        System.out.println(findPeakElement(tc1));
    }
}

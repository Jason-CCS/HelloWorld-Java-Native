package com.jason.sort_and_search;

import java.util.Arrays;

/**
 * Great practice to practice the merge sort.
 * The merge function here basically is the core part "merge" in MergeSort algorithm.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copiedNums1 = new int[m + n];
        for (int i = 0; i < m; i++) {
            copiedNums1[i] = nums1[i];
        }
        int nums1Pointer = 0, nums2Pointer = 0;
        int currentIdx = 0;

        while (nums1Pointer <= m - 1 && nums2Pointer <= n - 1) {
            if (copiedNums1[nums1Pointer] <= nums2[nums2Pointer]) {
                nums1[currentIdx] = copiedNums1[nums1Pointer];
                nums1Pointer++;
            } else {
                nums1[currentIdx] = nums2[nums2Pointer];
                nums2Pointer++;
            }
            currentIdx++;
        }

        if (nums1Pointer == m) {
            int remaining = n - nums2Pointer;
            for (int i = 0; i < remaining; i++) {
                nums1[currentIdx + i] = nums2[nums2Pointer + i];
            }
        } else {
            int remaining = m - nums1Pointer;
            for (int i = 0; i < remaining; i++) {
                nums1[currentIdx + i] = copiedNums1[nums1Pointer + i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 7, 100, 0, 0};
        int[] nums2 = {1, 99};
        MergeSortedArray m = new MergeSortedArray();
        m.merge(nums1, 4, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}

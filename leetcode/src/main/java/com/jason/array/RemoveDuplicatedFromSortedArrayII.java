package com.jason.array;

import java.util.Arrays;

/**
 * This problem is a really tricky one. I spent like 6 hours on it.
 */
public class RemoveDuplicatedFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int storePointer = -1, dupCounter = 0;
        for (int visitPointer = 1; visitPointer < nums.length; visitPointer++) {
            // count duplicate until dupCounter == 2
            // if it is 2, then that is the place to start replace.
            if (nums[visitPointer] == nums[visitPointer - 1] && storePointer == -1) {
                dupCounter++;
                if (dupCounter == 2)
                    storePointer = visitPointer;
            } else {
                if (storePointer == -1) {
                    dupCounter = 0;
                } else {
                    // use dupCounter==2 to differentiate how to move storePointer.
                    if (dupCounter == 2) {
                        if (nums[visitPointer] != nums[storePointer] && nums[visitPointer] != nums[storePointer - 1]) {
                            nums[storePointer] = nums[visitPointer];
                            dupCounter = 1;
                            storePointer++;
                        }
                    } else {
                        nums[storePointer] = nums[visitPointer];
                        if (nums[storePointer] == nums[storePointer - 1]) {
                            dupCounter++;
                        } else {
                            dupCounter = 1;
                        }
                        storePointer++;
                    }
                }
            }
        }

        return (storePointer == -1) ? nums.length : storePointer;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int[] nums2 = {1, 1};
        int[] nums3 = {1, 1, 1};
        int[] nums4 = {1, 1, 2, 2};
        int[] nums5 = {1, 1, 1, 2};
        int[] nums6 = {1, 1, 1, 1, 2};
        int[] nums7 = {1, 1, 1, 2, 2, 3};
        int[] nums8 = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        int[] nums9 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums10 = {0, 0, 0, 1, 2, 2, 4};
        System.out.println("k is " + removeDuplicates(nums));
        System.out.println("nums1 are " + Arrays.toString(nums));

        System.out.println("k is " + removeDuplicates(nums2));
        System.out.println("nums2 are " + Arrays.toString(nums2));

        System.out.println("k is " + removeDuplicates(nums3));
        System.out.println("nums3 are " + Arrays.toString(nums3));

        System.out.println("k is " + removeDuplicates(nums4));
        System.out.println("nums4 are " + Arrays.toString(nums4));

        System.out.println("k is " + removeDuplicates(nums5));
        System.out.println("nums5 are " + Arrays.toString(nums5));

        System.out.println("k is " + removeDuplicates(nums6));
        System.out.println("nums6 are " + Arrays.toString(nums6));

        System.out.println("k is " + removeDuplicates(nums7));
        System.out.println("nums7 are " + Arrays.toString(nums7));

        System.out.println("k is " + removeDuplicates(nums8));
        System.out.println("nums8 are " + Arrays.toString(nums8));

        System.out.println("k is " + removeDuplicates(nums9));
        System.out.println("nums9 are " + Arrays.toString(nums9));

        System.out.println("k is " + removeDuplicates(nums10));
        System.out.println("nums10 are " + Arrays.toString(nums10));
    }
}

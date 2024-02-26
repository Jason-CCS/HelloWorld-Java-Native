package com.jason.two_pointers;

import java.util.Arrays;

public class RemoveDuplicatedFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        // this starts from 1 because number of index 0 is anyway unique to other numbers
        // so there is no sense to use index 0 as the able-to-stored position.
        int maxLengthPointer = 0; // maxLengthPointer is the number of unique elements.
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[maxLengthPointer - 1]) {
                // find the first nums[i]!=nums[i-1] and store in the
                // position where is the next able-to-stored position.
                nums[maxLengthPointer] = nums[i];
                maxLengthPointer++;
            }
        }
        return maxLengthPointer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {};
        int[] nums4 = {1, 1};
        int[] nums5 = {0, 1};
        System.out.println("k is " + removeDuplicates(nums));
        System.out.println("nums are " + Arrays.toString(nums));

        System.out.println("k is " + removeDuplicates(nums2));
        System.out.println("nums are " + Arrays.toString(nums2));

        System.out.println("k is " + removeDuplicates(nums3));
        System.out.println("nums are " + Arrays.toString(nums3));

        System.out.println("k is " + removeDuplicates(nums4));
        System.out.println("nums are " + Arrays.toString(nums4));

        System.out.println("k is " + removeDuplicates(nums5));
        System.out.println("nums are " + Arrays.toString(nums5));
    }
}

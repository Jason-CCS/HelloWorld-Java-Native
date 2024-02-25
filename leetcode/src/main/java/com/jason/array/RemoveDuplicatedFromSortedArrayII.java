package com.jason.array;

import java.util.Arrays;

/**
 * This problem is a really tricky one. I spent like 8 hours on it.
 * Actually I think whether you can solve it or not is just based on a luck.
 * <p></p>
 * The version 1 is my own version:
 * storePointer is the index to indicate the position to store your next element.
 * dupCounter is the counter to count the duplicate number of storeCounter.
 * This method makes all things hard to think.
 * <p></p>
 * The version 2 is the better solution provided from LeetCode:
 * index is also the store Pointer like mine.
 * occurrence is the number of duplicate elements at the current i pointer in nums array.
 * nums[index] must be assigned by the new element when occurrence<=2.
 * This is the key point to solve this problem.
 * <p></p>
 * The version 3 is the best solution from LeetCode solutions:
 * The pointer maxLengthPointer indicate the position which has to be replaced by nums[i] anyway once the index is higher than 1.
 * And the position nums[maxLengthPointer] where you want to replaced by nums[i] does not allow the number is equal to nums[maxLengthPointer-2].
 * If we allow this case, then we will get the three identical number consecutively.
 * This is the key situation we want to avoid.
 *<p></p>
 * The version 3 teach you really need to decompose clearly what you think in your brain.
 * This solution actually works like what you think in your mind.
 */
public class RemoveDuplicatedFromSortedArrayII {
    public static int removeDuplicatesVersion1(int[] nums) {
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

    public static int removeDuplicatesVersion2(int[] nums) {
        int index = 1;
        int occurance = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                occurance++;
            } else {
                occurance = 1;
            }

            if (occurance <= 2) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static int removeDuplicatesVersion3(int[] nums) {
        int maxLengthPointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxLengthPointer == 0 || maxLengthPointer == 1 || nums[i] != nums[maxLengthPointer-2]) {
                nums[maxLengthPointer] = nums[i];
                maxLengthPointer++;
            }
        }

        return maxLengthPointer;
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
        System.out.println("k is " + removeDuplicatesVersion1(nums));
        System.out.println("nums1 are " + Arrays.toString(nums));

        System.out.println("k is " + removeDuplicatesVersion1(nums2));
        System.out.println("nums2 are " + Arrays.toString(nums2));

        System.out.println("k is " + removeDuplicatesVersion1(nums3));
        System.out.println("nums3 are " + Arrays.toString(nums3));

        System.out.println("k is " + removeDuplicatesVersion1(nums4));
        System.out.println("nums4 are " + Arrays.toString(nums4));

        System.out.println("k is " + removeDuplicatesVersion1(nums5));
        System.out.println("nums5 are " + Arrays.toString(nums5));

        System.out.println("k is " + removeDuplicatesVersion1(nums6));
        System.out.println("nums6 are " + Arrays.toString(nums6));

        System.out.println("k is " + removeDuplicatesVersion1(nums7));
        System.out.println("nums7 are " + Arrays.toString(nums7));

        System.out.println("k is " + removeDuplicatesVersion1(nums8));
        System.out.println("nums8 are " + Arrays.toString(nums8));

        System.out.println("k is " + removeDuplicatesVersion1(nums9));
        System.out.println("nums9 are " + Arrays.toString(nums9));

        System.out.println("k is " + removeDuplicatesVersion1(nums10));
        System.out.println("nums10 are " + Arrays.toString(nums10));
    }
}

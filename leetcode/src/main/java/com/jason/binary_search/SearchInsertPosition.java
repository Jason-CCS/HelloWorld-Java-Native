package com.jason.binary_search;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int leftPointer = 0, rightPointer = nums.length, midPointer = 0;
        while (leftPointer < rightPointer) {
            midPointer = (leftPointer + rightPointer) / 2;
            if (target < nums[midPointer]) {
                rightPointer = midPointer;
            } else {
                if (target == nums[midPointer])
                    return midPointer;
                else {
                    leftPointer = midPointer + 1;
                }
            }
        }

        return leftPointer;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1}, 2));

    }
}

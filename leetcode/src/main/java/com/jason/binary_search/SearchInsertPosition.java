package com.jason.binary_search;

/**
 * In this kind of position finding problem, we have to be very careful of the return position.
 * You might find that the position you figure out does not match the edge case.
 * For example, if you have the input array is [1, 3, 5, 6] and you want to find the insert position for target=7,
 * you would get the return value as 3.
 * The reason of resulting value 3 is because of your start rightPointer is nums.length-1 instead of nums.length.
 * Which means if you have the starting condition are int leftPointer=0, rightPointer=nums.length-1, midPointer,
 * you will get the wrong answer because you will never reach the index = 4.
 * (your leftPointer is 0 and rightPointer is 3 only.)
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int leftPointer = 0, rightPointer = nums.length, midPointer;
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

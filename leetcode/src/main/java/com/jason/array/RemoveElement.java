package com.jason.array;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int counterK = 0, tmp, leftPointer = 0, rightPointer = nums.length - 1;
        // here the less than is very important
        // how do I identify it as early as possible
        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] == val) {
                // find the first nums[rightPointer] is not equal to val
                while (rightPointer >= leftPointer && nums[rightPointer] == val) {
                    rightPointer--;
                }
                if (rightPointer > leftPointer) {
                    tmp = nums[leftPointer];
                    nums[leftPointer] = nums[rightPointer];
                    nums[rightPointer] = tmp;
                    counterK++;
                }
            } else {
                counterK++;
            }
            leftPointer++;
        }
        return counterK;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3, 2, 2, 3};
        val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3, 3};
        val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{};
        val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}

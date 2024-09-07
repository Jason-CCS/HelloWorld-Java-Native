package com.jason.two_pointers;

/**
 * Problem: 287
 * Difficulty: Medium
 * This is tricky one. You won't know 使用龜兔賽跑的方法可以推論duplicate number.
 * 不太實用說真的，陣列裡面的數字必須小於總數，才會有用。
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length < 2) {
            return -1;  // Invalid input
        }

        // Step 1: Using Floyd's Tortoise and Hare Algorithm to find intersection point
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Step 2: Find the entrance to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
//        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
//        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
//        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{3, 3, 3, 3, 3}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}

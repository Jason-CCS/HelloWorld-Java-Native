package com.jason.array_and_string;

/**
 * Problem: 169
 * Difficulty: Easy
 * Find the majority element in an array (occurs more than n/2 times)
 */
public class MajorityElement {

    /**
     * Use Moore Voting Algorithm.
     * The major element will anyway in the end take the lead position of the array by counting.
     * This assumption guarantees that even if the count is reset to 0 by other elements,
     * the majority element will eventually regain the lead.
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int candidate, count;
        candidate = nums[0];
        count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}

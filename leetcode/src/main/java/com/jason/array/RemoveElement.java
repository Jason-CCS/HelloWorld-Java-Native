package com.jason.array;

import java.util.Arrays;

/**
 * This is a two-pointer problem. Very good one to practice the two-pointer technique.
 * Two-pointer technique can make the time complexity only O(n). It's fantastic.
 * The critical points are:
 * 1. The pointer at intersection area should be "<" or "<=" (counterpart is ">" or ">=") is the key point.
 * 2. Start position and end position should be carefully considered.
 * <p>
 * Using this problem as the example,
 * The requirement is the <code>nums[lp]</code> is visited or not.
 * And the visited criteria are:
 * 1. have you compared the nums[lp] == val?
 * 2. have you compared the nums[rp] == val?
 * 3. if nums[lp/rp]!=val, have you counterK++?
 * <p>
 * So it comes down to a key point which is are you clear enough with your visited criteria?
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int counterK = 0, lp = 0, rp = nums.length - 1, tmp;
        // how do I identify "<=" or "<" as early as possible?
        while (lp <= rp) {
            if (nums[lp] == val) {
                // how do I identify "<=" or "<" as early as possible?
                while (lp < rp) {
                    // find the first nums[rightPointer] is not equal to val
                    if (nums[rp] != val) {
                        tmp = nums[lp];
                        nums[lp] = nums[rp];
                        nums[rp] = tmp;
                        counterK++;
                        rp--;
                        break;
                    } else {
                        rp--;
                    }
                }
            } else {
                counterK++;
            }
            lp++;
        }
        return counterK;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3, 2, 2, 3};
        val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{};
        val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 0, 0};
        val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 2, 2};
        val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}

package com.jason.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 228
 * Difficulty: Easy
 */
public class SummaryRanges {
    /**
     * Time Complexity: O(n)
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;

        int start = nums[0];
        if (nums.length == 1) {
            list.add(Integer.toString(start));
            return list;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (count == 0) {
                    list.add(Integer.toString(start));
                    start = nums[i];
                } else {
                    list.add(String.format("%d->%d", start, start + count));
                    count = 0;
                    start = nums[i];
                }
            } else {
                count++;
            }
        }

        if (count == 0) {
            list.add(Integer.toString(start));
        } else {
            list.add(String.format("%d->%d", start, start + count));
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));

    }
}

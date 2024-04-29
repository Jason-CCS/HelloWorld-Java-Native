package com.jason.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: 128
 * Difficulty: Medium
 * The current problem in the editor aims to implement a solution for finding the longest consecutive sequence in
 * an integer array. It includes two versions of the solution with different approaches and time complexities.
 */
public class LongestConsecutiveSequence {

    /**
     * Version 1
     * My solution, use value to store range[min, max].
     * Time Complexity is O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, int[]> map = new HashMap<>(); // (num, range)
        for (int num : nums) {
            if (!map.containsKey(num)) {
                // one up
                int min = num, max = num;
                if (map.containsKey(num - 1)) {
                    min = map.get(num - 1)[0];
                }
                // one down
                if (map.containsKey(num + 1)) {
                    max = map.get(num + 1)[1];
                }
                map.put(num, new int[]{min, max});
                if (min != num)
                    map.put(min, new int[]{min, max});
                if (max != num)
                    map.put(max, new int[]{min, max});
                maxLength = Math.max(maxLength, max - min + 1);
            }
        }
        return maxLength;
    }

    /**
     * Version 2
     * Solution from leetcode.
     * This one is faster. Use HashSet to first run n time to store in to HashSet.
     * Second run iterate each element once only.
     * Once visiting one of the elements, this element will be removed.
     * Removed is O(1).
     * Time complexity is O(n).
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

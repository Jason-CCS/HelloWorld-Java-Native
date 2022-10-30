package com.jason;

import java.util.HashMap;

/**
 * Sliding window, HashTable, String
 * Sliding window 目前看起來是可以以兩個index匡起來的一個視窗，在這邊就是i, j，以一個for跑i跟j就可以像一個視窗檢視裡面的狀況
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "172-3948j-naduh-f6a934jr;lasdfkh1-2893y9ha.sdnvads9ufy-198239ujdianskjdnv-1y34-r98zdsfhpwe8ey-183-49879efhakjdsajd f sdf13098jfojdsvpaiy";
        System.out.println(solution.lengthOfLongestSubstring(test1));
        System.out.println(solution.lengthOfLongestSubstring(test2));
        System.out.println(solution.lengthOfLongestSubstring(test3));
        System.out.println(solution.lengthOfLongestSubstring(test4));

    }
}

package com.jason.sliding_window;

/**
 * Problem: 424
 * Difficulty: Medium
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int oldK = k;
        int start = 0, end = 0, nextStart = 0;
        int max = 1;

        while ((s.length() - end) > max) {
            end = start + 1;
            if (end >= s.length())
                break;
            while (end < s.length()) {
                if (s.charAt(end) != s.charAt(start)) {
                    if (k == oldK)
                        nextStart = end;
                    k--;
                    if (k < 0) break;
                }
                end++;
            }
            max = Math.max(max, end - start);
            start = nextStart;
            end = start;
            k = oldK;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }
}

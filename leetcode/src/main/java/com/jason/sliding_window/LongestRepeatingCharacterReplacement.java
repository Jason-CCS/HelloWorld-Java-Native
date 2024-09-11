package com.jason.sliding_window;

/**
 * Problem: 424
 * Difficulty: Medium
 */
public class LongestRepeatingCharacterReplacement {
    /**
     * This solution still has error for the case "BAAAB", and k is 2.
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if (s.length() == 1) return 1;
        int oldK = k;
        int start = 0, end = 0, newStart = 0;
        int max = 1;

        while (s.length() - start > max) {
            for (end = start + 1; end < s.length(); end++) {
                if (s.charAt(end) != s.charAt(start)) {
                    if (k == oldK)
                        newStart = end;
                    k--;
                    if (k < 0) break;
                }
            }
            max = Math.max(max, end - start);
            start = newStart;
            k = oldK;
        }

        String rs = new StringBuilder(s).reverse().toString();

        start = 0;
        newStart = 0;
        while (rs.length() - start > max) {
            for (end = start + 1; end < rs.length(); end++) {
                if (rs.charAt(end) != rs.charAt(start)) {
                    if (k == oldK)
                        newStart = end;
                    k--;
                    if (k < 0) break;
                }
            }
            max = Math.max(max, end - start);
            start = newStart;
            k = oldK;
        }

        return max;
    }

    /**
     * This solution is correct. O(n)
     * It maintain a alphabet array to remember the current count stats in the sliding window.
     * The index of sling window is (start, end).
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement2(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABCCCCC", 2));
    }
}

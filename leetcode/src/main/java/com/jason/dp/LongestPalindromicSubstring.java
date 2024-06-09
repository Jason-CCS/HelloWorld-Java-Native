package com.jason.dp;

/**
 * Problem: 5
 * Difficulty: Medium
 * The problem is intended to find the longest palindromic substring within a given string.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int end = s.length() - 1;
        int start = 0;
        int maxLength = 1;
        int leftMost = end;
        int pLeft = 0;
        int pRight = 0;
        int head, tail;

        while (start < end) {
            while (start < end) {
                if (end - start + 1 <= maxLength) break;
                tail = end;
                head = start;
                // check if is palindrome
                while (head < tail && head < leftMost && s.charAt(head) == s.charAt(tail)) {
                    head++;
                    tail--;
                    if (head >= tail) { // if true, then start~end is palindrome.
                        if (end - start + 1 > maxLength) {
                            // update the maxLength
                            pLeft = start;
                            pRight = end;
                            maxLength = end - start + 1;
                        }
                        leftMost = start;
                    }
                }
                start++;
            }
            end--;
            start = 0;
        }

        return s.substring(pLeft, pRight + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}

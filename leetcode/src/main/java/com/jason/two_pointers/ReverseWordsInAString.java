package com.jason.two_pointers;

/**
 * Problem: 151
 * Difficulty: Medium
 * This problem requires developing an algorithm to reverse the order of words in a given string,
 * removing any leading or trailing spaces, and ensuring only a single space separates words.
 */
public class ReverseWordsInAString {
    /**
     * Use two pointers approach. Start from the tail to the head of s.
     * Time complexity: O(n)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int head = s.length() - 1, tail = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (tail >= 0) {
            if (s.charAt(head) == ' ' && s.charAt(tail) == ' ') {
                head--;
                tail--;
            } else if (s.charAt(head) != ' ' && s.charAt(tail) != ' ') {
                head--;
            }
            if ((head == -1 || s.charAt(head) == ' ') && (tail != -1 && s.charAt(tail) != ' ')) {
                sb.append(s.substring(head + 1, tail + 1));
                sb.append(" ");
                tail = head;
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("  hello world  "));
    }
}

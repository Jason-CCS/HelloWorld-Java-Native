package com.jason.two_pointers;

/**
 * Problem: 151
 * Difficulty: Medium
 */
public class ReverseWordsInAString {
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

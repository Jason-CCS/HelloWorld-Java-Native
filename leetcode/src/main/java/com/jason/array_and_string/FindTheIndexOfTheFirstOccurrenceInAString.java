package com.jason.array_and_string;

/**
 * Problem: 28
 * Difficulty: Easy
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    /**
     * Java has string.indexOf() to return the value.
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        if (needleLength > haystackLength)
            return -1;
        char head = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == head) {
                if (i + needleLength <= haystackLength)
                    if (haystack.substring(i, i + needleLength).equals(needle))
                        return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr1("sadbutsad", "sad"));
        System.out.println(strStr1("leetcode", "leeto"));

        System.out.println(strStr2("sadbutsad", "sad"));
        System.out.println(strStr2("leetcode", "leeto"));
        System.out.println(strStr2("aaa", "aaaa"));
        System.out.println(strStr2("mississippi", "issipi"));
    }
}

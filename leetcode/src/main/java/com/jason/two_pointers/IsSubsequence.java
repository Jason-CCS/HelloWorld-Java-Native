package com.jason.two_pointers;

/**
 * Easy
 */
public class IsSubsequence {

    /**
     * first version
     * Time complexity: less than O(n)
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.isEmpty()) return true;
        int sLength = s.length();
        int tLength = t.length();
        int sPointer = 0;

        for (int i = 0; i < tLength; i++) {
            if (t.charAt(i) == s.charAt(sPointer)) sPointer++;
            if (sPointer == sLength) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc "));
        System.out.println(isSubsequence("", "ahbgdc "));
        System.out.println(isSubsequence("ad", "ahbgdc "));
        System.out.println(isSubsequence("abc", ""));
        System.out.println(isSubsequence("abc", "a"));
    }
}

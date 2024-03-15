package com.jason.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 9
 * Difficulty: Easy
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        List<Integer> list = new ArrayList<>();
        while (x >= 1) {
            list.add(x % 10);
            x = x / 10;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r)))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(12121));
//        System.out.println(isPalindrome(331133));
//        System.out.println(isPalindrome(3311));
        System.out.println(isPalindrome(1410110141));
//        System.out.println(Integer.MAX_VALUE);
    }
}

package com.jason.array_and_string;

import java.util.Map;
import java.util.HashMap;

/**
 * Problem: 13
 * Difficulty: Easy
 * RomanToInteger involves converting a Roman numeral string to an equivalent decimal integer, following the standard rules of Roman numeral interpretation.
 */
public class RomanToInteger {
    static Map<Character, Integer> romanMap = new HashMap<>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    /**
     * The version 2 is the best solution from LeetCode solutions:
     * It compares whether s[i] < s[i+1]. If it is, then we sum = sum + toInt(s[i+1]) - toInt(s[i])
     *
     * @param s
     * @return
     */
    public static int romanToIntVersion2(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                sum = sum + romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));
                i++;
            } else {
                sum = sum + romanMap.get(s.charAt(i));
            }
        }

        return sum;
    }

    private static final char[] ixc = {'I', 'X', 'C'};

    public int romanToInt(String s) {
        int sum = 0;
        int index = 0;
        int length = s.length();

        while (index < s.length()) {
            char c = s.charAt(index);
            if (charsContainsChar(ixc, c) && (index + 1 < length) && charsContainsChar(foo(c), s.charAt(index + 1))) {
                char nextc = s.charAt(index + 1);
                sum = sum + charToNumber(nextc) - charToNumber(c);
                index = index + 2;
            } else {
                sum = sum + charToNumber(c);
                index = index + 1;
            }
        }
        return sum;
    }

    private static boolean charsContainsChar(char[] chars, char c) {
        for (char aChar : chars) {
            if (aChar == c) {
                return true;
            }
        }
        return false;
    }

    private static char[] foo(char c) {
        switch (c) {
            case 'I':
                return new char[]{'V', 'X'};
            case 'X':
                return new char[]{'L', 'C'};
            case 'C':
                return new char[]{'D', 'M'};
        }
        return new char[]{};
    }

    private static int charToNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new RomanToInteger().romanToInt("III"));
//        System.out.println(new RomanToInteger().romanToInt("LVIII"));
//        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));

        System.out.println(romanToIntVersion2("III"));
        System.out.println(romanToIntVersion2("LVIII"));
        System.out.println(romanToIntVersion2("MCMXCIV"));
    }
}

package com.jason;

/**
 * this is my version.
 * There is one better solution is: compare if s[i] < s[i+1], then toInt(s[i+1]) - toInt(s[i])
 */
public class S13 {
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
        System.out.println(new S13().romanToInt("I"));
        System.out.println(new S13().romanToInt("III"));
        System.out.println(new S13().romanToInt("IV"));
        System.out.println(new S13().romanToInt("VI"));
        System.out.println(new S13().romanToInt("IX"));
        System.out.println(new S13().romanToInt("XI"));
        System.out.println(new S13().romanToInt("XL"));
        System.out.println(new S13().romanToInt("XC"));
        System.out.println(new S13().romanToInt("CD"));
        System.out.println(new S13().romanToInt("CM"));
        System.out.println(new S13().romanToInt("MMMCMXCIX"));
        System.out.println(new S13().romanToInt("IVXLCDM"));
    }
}

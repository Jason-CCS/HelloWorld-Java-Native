package com.jason.array_and_string;

/**
 * Problem: 12
 * Difficulty: Medium
 * This problem requires converting an integer into its equivalent Roman numeral.
 */
public class IntegerToRoman {
    private static String[] thousands = {"", "M", "MM", "MMM"};
    private static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /**
     * Version 1
     * Time complexity is the same as the version 2.
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int base = 1000;
        while (base >= 1) {
            if (base == 1000)
                sb.append(thousands[num / base]);
            if (base == 100)
                sb.append(hundreds[num / base]);
            if (base == 10)
                sb.append(tens[num / base]);
            if (base == 1)
                sb.append(ones[num / base]);
            num = num % base;
            base = base / 10;
        }
        return sb.toString();
    }

    private static final int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
    };

    private static final String[] symbols = {
            "M","CM","D","CD",
            "C","XC","L","XL",
            "X","IX","V","IV",
            "I"
    };

    /**
     * Version 2
     * Time complexity is the same as the version 1.
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(3599));
    }
}

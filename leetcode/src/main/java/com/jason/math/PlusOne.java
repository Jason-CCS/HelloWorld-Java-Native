package com.jason.math;

import java.util.Arrays;

/**
 * Problem: 66
 * Difficulty: Easy
 * The purpose of the problem is to implement a function which increments a number represented as an array of digits
 * and returns the result also as an array of digits.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] carrying = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + carry > 9) {
                digits[i] = 0;
                carrying[i] = 0;
            } else {
                digits[i] += carry;
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            carrying[0] = 1;
            return carrying;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne instance = new PlusOne();
        System.out.println(Arrays.toString(instance.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(instance.plusOne(new int[]{9,9,9,9})));
        System.out.println(Arrays.toString(instance.plusOne(new int[]{9,8,9,9})));
    }
}

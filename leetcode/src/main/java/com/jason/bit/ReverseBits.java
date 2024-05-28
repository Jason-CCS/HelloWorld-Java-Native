package com.jason.bit;

/**
 * Problem: 190
 * Difficulty: Easy
 * The purpose of the problem in the current editor is to reverse the bits of a given integer.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        n = Integer.reverse(n);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }
}

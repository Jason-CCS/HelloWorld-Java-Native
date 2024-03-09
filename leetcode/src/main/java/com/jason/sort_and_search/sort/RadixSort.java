package com.jason.sort_and_search.binary_search.sort;

import java.util.Arrays;

/**
 * The key idea behind Radix Sort is to exploit the concept of place value.
 * It assumes that sorting numbers digit by digit will eventually result in a fully sorted list.
 * Radix Sort can be performed using different variations, such as Least Significant Digit (LSD) Radix Sort or Most Significant Digit (MSD) Radix Sort.
 * O(nk), k is the digit number of max number, n is length of input ary
 * Best O(nk), Average O(nk), Worst O(nk).
 */
public class RadixSort {

    public static int[] radixSort(int[] inputAry) {
        int max = 0; // find how many digits does the max number have
        int n = inputAry.length;
        for (int i = 0; i < n; i++) { // O(n)
            max = Math.max(max, inputAry[i]);
        }

        for (int exp = 1; max / exp > 0; exp *= 10) { // 10 times exp each loop to change the place digit, O(k), k is the loop times.
            inputAry = countSort(inputAry, exp);
        }
        return inputAry;
    }

    public static int[] countSort(int[] inputAry, int exp) {
        int[] countAry = new int[10];
        int n = inputAry.length;
        int[] outputAry = new int[n];

        for (int i = 0; i < inputAry.length; i++) { // counting, O(n)
            countAry[inputAry[i] / exp % 10]++;
        }

        for (int i = 1; i < countAry.length; i++) { // cumulative sum, O(10)
            countAry[i] += countAry[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { // O(n)
            outputAry[countAry[inputAry[i] / exp % 10] - 1] = inputAry[i];
            countAry[inputAry[i] / exp % 10]--;
        }

        return outputAry;
    }

    public static void main(String[] args) {
        int[] testcase1 = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] testcase2 = new int[]{0, 2, 3, 7, 5, 1, 4, 2, 8, 0, 9, 0};

        System.out.println(Arrays.toString(radixSort(testcase1)));
        System.out.println(Arrays.toString(radixSort(testcase2)));
    }
}

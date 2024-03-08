package com.jason.sort_and_search.binary_search.sort;

import java.util.Arrays;

public class MergeSort {

    // this is the book version: Cracking the coding interview.
    public static int[] merge(int[] inputAry, int[] helperAry, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helperAry[i] = inputAry[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helperAry[helperLeft] <= helperAry[helperRight]) {
                inputAry[current] = helperAry[helperLeft];
                helperLeft++;
            } else {
                inputAry[current] = helperAry[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            inputAry[current + i] = helperAry[helperLeft + i];
        }
        return inputAry;
    }

    public static int[] mergeSort(int[] inputAry, int[] helperAry, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            mergeSort(inputAry, helperAry, low, middle);
            mergeSort(inputAry, helperAry, middle + 1, high);
        }
        return merge(inputAry, helperAry, low, middle, high);
    }

    public static void main(String[] args) {
        int[] testcase1 = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] testcase2 = new int[]{0, 2, 3, 7, 0, 1, 4, 2, 8, 0, 9, 0};


        System.out.println(Arrays.toString(mergeSort(testcase1, new int[testcase1.length], 0, testcase1.length - 1)));
        System.out.println(Arrays.toString(mergeSort(testcase2, new int[testcase2.length], 0, testcase2.length - 1)));
    }
}

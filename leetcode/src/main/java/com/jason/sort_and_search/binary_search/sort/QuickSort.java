package com.jason.sort_and_search.binary_search.sort;

import java.util.Arrays;

/**
 * QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element as a pivot
 * and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.
 */
public class QuickSort {

    public static int partition(int[] inputAry, int left, int right) {
        int pivotElem = inputAry[(left + right) / 2];

        /*
         * This loop will result in all the number less than or equal to the pivot number
         * will all be placed on the left side of "left" pointer.
         */
        while (left <= right) { // run till visit each other
            while (inputAry[left] < pivotElem) left++;
            while (inputAry[right] > pivotElem) right--;
            if (left <= right) { // the same index to swap is allowable, just let the left and right to pass through each other.
                int tmp = inputAry[left];
                inputAry[left] = inputAry[right];
                inputAry[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static int[] quickSort(int[] inputAry, int left, int right) {
        int index = partition(inputAry, left, right);
        if (left < index - 1) {
            quickSort(inputAry, left, index - 1);
        }
        if (index < right) {
            quickSort(inputAry, index, right);
        }
        return inputAry;
    }

    public static void main(String[] args) {
        int[] testcase1 = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] testcase2 = new int[]{0, 2, 3, 7, 0, 1, 4, 2, 8, 0, 9, 0};

        System.out.println(Arrays.toString(quickSort(testcase1, 0, testcase1.length - 1)));
        System.out.println(Arrays.toString(quickSort(testcase2, 0, testcase2.length - 1)));
    }
}

package com.jason.sort_and_search.binary_search.sort;

import java.util.Arrays;

/**
 * The key to counting sort is initialize a counting array with size [max(n)+1].
 * Algorithm:
 * Declare an auxiliary array countArray[] of size max(inputArray[])+1 and initialize it with 0.
 * Traverse array inputArray[] and map each element of inputArray[] as an index of countArray[] array, i.e., execute countArray[inputArray[i]]++ for 0 <= i < N.
 * Calculate the prefix sum at every index of array inputArray[].
 * Create an array outputArray[] of size N.
 * Traverse array inputArray[] from end and update outputArray[ countArray[ inputArray[i] ] – 1] = inputArray[i]. Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]--.
 * time complexity: average O(k+n)
 */
public class CountingSort {

    public static int[] countSort(int[] inputArray) {
        int max = 0;
        int n = inputArray.length;

        for (int i = 0; i < n; i++) { // O(n)
            max = Math.max(max, inputArray[i]);
        }

        int[] countAry = new int[max + 1];
        int k = countAry.length;

        for (int i = 0; i < n; i++) { // counting, O(n)
            countAry[inputArray[i]]++;
        }

        for (int i = 1; i < k; i++) { // get the prefix sum (cumulative sum). This sum will be the index for outputAry, O(k)
            countAry[i] = countAry[i] + countAry[i - 1];
        }

        int[] outputAry = new int[n];

        for (int i = n - 1; i >= 0; i--) { // traverse from tail to maintain the array order stability, O(n)
            outputAry[countAry[inputArray[i]] - 1] = inputArray[i];
            countAry[inputArray[i]]--;
        }

        return outputAry;
    }

    public static void main(String[] args) {
        int[] testcase1 = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] testcase2 = new int[]{0, 2, 3, 7, 5, 1, 4, 2, 8, 0, 9, 0};

        System.out.println(Arrays.toString(countSort(testcase1)));
        System.out.println(Arrays.toString(countSort(testcase2)));

    }
}

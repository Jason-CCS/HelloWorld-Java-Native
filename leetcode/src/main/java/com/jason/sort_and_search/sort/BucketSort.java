package com.jason.sort_and_search.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Bucket sort is a sorting technique that involves dividing elements into various groups, or buckets.
 * These buckets are formed by uniformly distributing the elements.
 * Once the elements are divided into buckets, they can be sorted using any other sorting algorithm.
 * Finally, the sorted elements are gathered together in an ordered fashion.
 * Best O(n+k), Average O(n+k), Worst O(n^2).
 */
public class BucketSort {

    public static float[] bucketSort(float[] inputAry) {
        if (inputAry.length == 0)
            return null;
        int bucketSize = 10;
        LinkedList<Float>[] buckets = new LinkedList[bucketSize];

        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < inputAry.length; i++) {
            int idx = (int) inputAry[i] * 10;
            buckets[idx].add(inputAry[i]);
        }

        for (int i = 0; i < bucketSize; i++) {
            Collections.sort(buckets[i]);
        }

        LinkedList<Float> resultList = new LinkedList<>();
        for (int i = 0; i < bucketSize; i++) {
            resultList.addAll(buckets[i]);
        }

        float[] result = new float[resultList.size()];
        int index = 0;
        for (Float floatValue : resultList) {
            result[index++] = floatValue;
        }

        return result;
    }

    public static void main(String[] args) {
        float[] arr = {(float) 0.897, (float) 0.565,
                (float) 0.656, (float) 0.1234,
                (float) 0.665, (float) 0.3434};

        System.out.println(Arrays.toString(bucketSort(arr)));
    }
}

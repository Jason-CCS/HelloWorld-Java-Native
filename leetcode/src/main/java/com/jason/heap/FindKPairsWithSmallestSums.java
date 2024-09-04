package com.jason.heap;

import java.util.*;

/**
 * Problem: 373
 * Difficulty: Medium
 */
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (maxHeap.size() != k) {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                } else { // when maxHeap.size == k, we can start to swap the smaller one with max heap.
                    int[] e = maxHeap.peek();
                    if (nums1[i] + nums2[j] >= (e[0] + e[1])) {
                        break;
                    } else {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        int[] twoNumbers;
        while (!maxHeap.isEmpty()) {
            twoNumbers = maxHeap.poll();
            result.add(Arrays.asList(twoNumbers[0], twoNumbers[1]));
        }

        return result;
    }

    public static void main(String[] args) {

    }
}

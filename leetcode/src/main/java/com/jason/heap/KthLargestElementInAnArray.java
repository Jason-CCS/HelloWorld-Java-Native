package com.jason.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: 215
 * Difficulty: Medium
 */
public class KthLargestElementInAnArray {
    /**
     * The first version that I can think of.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer i : nums) {
            heap.offer(i);
        }

        int result = -1;
        for (int i = 0; i < k; i++) {
            result = heap.poll();
        }

        return result;
    }

    /**
     * The second version from LeetCode solutions.
     * Use k-sized min-heap, the top of the heap will be the k-th largest element in nums.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // first put k elements into the heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // swap the element if the element is bigger than the min of the heap.
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] tc1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest2(tc1, 4));
    }
}

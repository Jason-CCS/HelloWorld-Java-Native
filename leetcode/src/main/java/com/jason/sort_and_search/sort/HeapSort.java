package com.jason.sort_and_search.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * HeapSort is using the heap tree data structure to sort the input array.
 * Each insert and remove, or here add and poll, is O(log(n)).
 * So the total time to insert and remove is n*log(n)+n*log(n).
 * Best O(nlog(n)), Average O(nlog(n)), Worst O(nlog(n)).
 */
public class HeapSort {

    public static int[] heapSort(int[] inputAry){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); // without specifying, the comparator is natural order.
        for (int e: inputAry)
            maxHeap.add(e);
        int[] resultAry = new int[maxHeap.size()];
        int index = 0;
        while(!maxHeap.isEmpty()){
            resultAry[index]=maxHeap.poll();
            index++;
        }

        return resultAry;
    }

    public static void main(String[] args) {
        int[] testcase1 = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] testcase2 = new int[]{0, 2, 3, 7, 5, 1, 4, 2, 8, 0, 9, 0};

        System.out.println(Arrays.toString(heapSort(testcase1)));
        System.out.println(Arrays.toString(heapSort(testcase2)));
    }
}

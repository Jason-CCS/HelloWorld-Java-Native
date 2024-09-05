package com.jason.array_and_string;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

/**
 * Problem: 347
 * Difficulty: Medium
 * The purpose of the code in your current editor is to find the k most frequent elements in an array.
 * These elements are returned in an array, ordered by their frequency in the input array.
 */
public class TopKFrequentElements {
    /**
     * This approach is ok, but time efficiency is bad.
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Elem> minHeap = new PriorityQueue<>(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return (o1.freq - o2.freq);
            }
        });
        HashMap<Integer, Elem> map = new HashMap<>();

        for (int num : nums) {
            Elem elem = map.get(num);
            if (elem == null)
                elem = new Elem(num, 0);
            map.put(num, elem);
            if (minHeap.size() < k) {
                elem.freq++;
                if (minHeap.contains(elem)) {
                    minHeap.remove(elem);
                    minHeap.offer(elem);
                } else {
                    minHeap.offer(elem);
                }
            } else { // size == k
                if (elem.freq + 1 > minHeap.peek().freq) {
                    elem.freq++;
                    if (minHeap.contains(elem)) {
                        minHeap.remove(elem);
                        minHeap.add(elem);
                    } else {
                        minHeap.poll();
                        minHeap.offer(elem);
                    }
                } else {
                    elem.freq++;
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().num;
        }
        return res;
    }

    static class Elem {
        int num;
        int freq;

        public Elem(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    /**
     * This approach is ok, but time efficiency is bad.
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        TreeSet<Elem> treeSet = new TreeSet<>(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                int freqComparison = Integer.compare(o2.freq, o1.freq);
                return freqComparison != 0 ? freqComparison : Integer.compare(o1.num, o2.num); // Descending
            }
        });

        HashMap<Integer, Elem> map = new HashMap<>();
        for (int num : nums) {
            Elem elem = map.get(num);
            if (elem == null) {
                elem = new Elem(num, 1);
                map.put(num, elem);
                treeSet.add(elem);
            } else {
                treeSet.remove(elem);
                elem.freq++;
                treeSet.add(elem);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = treeSet.pollFirst().num;
        }
        return res;
    }

    /**
     * This approach is so much better.
     * This approach removes all difficult operation in first for loop.
     * And heapify a heap with a collection only take O(n) time.
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Elem> map = new HashMap<>();
        for (int num : nums) {
            Elem elem = map.get(num);
            if (elem == null) {
                elem = new Elem(num, 0);
            }
            elem.freq++;
            map.put(num, elem);
        }

        PriorityQueue<Elem> maxHeap = new PriorityQueue<>(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return o2.freq - o1.freq;
            }
        });
        maxHeap.addAll(map.values());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().num;
        }
        return res;
    }


    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent3(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent3(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent3(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2)));
    }
}

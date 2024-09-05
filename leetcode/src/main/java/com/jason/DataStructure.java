package com.jason;

import java.util.*;

/**
 * All the basic data structure in Java.
 */
public class DataStructure {

    public static void main(String[] args) {
        /**
         * If you want to random access, please use Array structure.
         */
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(new Object());
        arrayList.remove(new Object());

        /**
         * If you want to have a O(1) operation from both head and tail, and low memory overhead Stack or Deque, please use ArrayDeque.
         */
        Deque stack = new ArrayDeque();
        stack.push(new Object());
        Object obj = stack.pop();
        obj = stack.peek();

        Deque deque = new ArrayDeque();
        deque.offerFirst(new Object());
        deque.offerLast(new Object());
        deque.pollFirst();
        deque.pollLast();

        /**
         * If you want to have a one-way queue or doubly linked list. ArrayDeque and LinkedList are all good for O(1) poll.
         * ArrayDeque has low memory overhead, but need time to resize and copy elements when beyond capacity.
         * LinkedList has higher memory overhead, but no capacity issue.
         * Therefore, if your queue tends to grow a lot and can't well predict its size beforehand,
         * then LinkedList can be a good choice as it won't need any resizing operations.
         */
        // doubly linked list
        LinkedList doublyLinkedList = new LinkedList();
        doublyLinkedList.addFirst(new Object());
        obj = doublyLinkedList.removeFirst();
        doublyLinkedList.addLast(new Object());
        obj = doublyLinkedList.removeLast();

        Queue queue = new LinkedList();
        queue.offer(new Object());
        queue.peek();
        queue.poll();

        /**
         * Tree, a red-black tree. For binary search with O(log(n)) time.
         */
        TreeMap treeMap = new TreeMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
//                if (o1 < o2)
//                    return negative int;
//                else if (o1 == o2)
//                    return 0;
//                else // o1 > o2
//                    return positive int;
                return 0;
            }
        });
        treeMap.put(new Object(), new Object());
        treeMap.remove(new Object());

        /**
         * min or max heap
         */
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // This is default setting. It is min heap.
                // return o2 - o1 // This is max heap.
            }
        });
        heap.offer(1);
        obj = heap.poll();

        /**
         * Matrix
         */
        int[][] matrix = new int[5][5];
    }

    /**
     * Graph
     */
    static class Node {
        public String name;
        public Node[] children;
    }

    static class Graph {
        public Node[] nodes;
    }
}

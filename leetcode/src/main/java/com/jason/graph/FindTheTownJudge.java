package com.jason.graph;

import java.util.*;

public class FindTheTownJudge {

    public static void main(String[] args) {
        /**
         * Array structure
         */
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(new Object());
        arrayList.remove(new Object());

        Queue queue = new ArrayDeque<>();
        queue.add(new Object());
        queue.remove(new Object());
        queue.offer(new Object());
        Object obj = queue.poll();

        Deque deque = new ArrayDeque();
        deque.offerFirst(new Object());
        deque.offerLast(new Object());

        Deque stack = new ArrayDeque();
        stack.push(new Object());
        obj = stack.pop();
        obj = stack.peek();

        /**
         * LinkedList structure
         */
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Object());
        linkedList.remove(new Object());

        // doubly linked list
        linkedList.addFirst(new Object());
        obj = linkedList.removeFirst();
        linkedList.addLast(new Object());
        obj = linkedList.removeLast();

        Queue queue2 = new LinkedList();
        Deque deque2 = new LinkedList();
        Deque stack2 = new LinkedList();
        stack2.push(new Object());
        obj = stack2.pop();

        /**
         * Tree
         */
        TreeMap treeMap = new TreeMap<>();
        treeMap.put(new Object(), new Object());
        treeMap.remove(new Object());

        /**
         * heap
         */
        PriorityQueue heap = new PriorityQueue();
        heap.offer(new Object());
        obj = heap.poll();

        /**
         * Graph
         */

        /**
         * Matrix
         */
    }
}

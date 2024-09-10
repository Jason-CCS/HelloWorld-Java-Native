package com.jason;

import java.util.*;

/**
 * All the basic data structure in Java.
 */
public class DataStructure {
    public static void main(String[] args) {
        /**
         * Array
         * If you want to random access, please use Array structure.
         */
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(new Object());
        arrayList.remove(new Object());

        /**
         * Stack and Deque(Queue)
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
         * Doubly linkedList, Queue
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
         * Matrix
         */
        int[][] matrix = new int[5][5];

        StaticInnerClass staticInnerClass = new StaticInnerClass();
        InnerClass a = new DataStructure().new InnerClass(); // InnerClass is a class you can access only when you instantiate a DataStructure.
    }

    /**
     * Graph
     */
    static class Node {
        public final int key;
        public List<Node> neighbors;
        public boolean visited = false;
        public boolean marked = false;
        public int level;
        public int distance = -1;

        public Node(int key) {
            this.key = key;
            neighbors = new LinkedList<>();
        }

        public void addChild(Node child) {
            neighbors.add(child);
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        @Override
        public String toString() {
            return String.format("key=%d", key);
        }
    }

    static class Graph {
        public Node root;
        public HashMap<Integer, Node> nodes;

        public Graph() {
            this.nodes = new HashMap<>();
        }

        public Graph(Node root) {
            this.root = root;
            this.nodes = new HashMap<>();
            this.nodes.put(root.key, root);
        }

        public Graph(int rootKey) {
            this.root = new Node(rootKey);
            this.nodes = new HashMap<>();
            this.nodes.put(root.key, root);
        }

        public void addRoot(int rootKey) {
            if (root == null) {
                this.root = new Node(rootKey);
                this.nodes.put(rootKey, root);
            }
        }

        public void addEdge(int fromKey, int toKey) {
            Node fromNode = nodes.get(fromKey);
            Node toNode = nodes.get(toKey);
            if (fromNode == null) {
                fromNode = new Node(fromKey);
            }
            if (toNode == null) {
                toNode = new Node(toKey);
            }
            fromNode.addChild(toNode);
            toNode.addChild(fromNode);
            this.nodes.put(fromKey, fromNode);
            this.nodes.put(toKey, toNode);
        }

        public Node getNode(int key) {
            return nodes.get(key);
        }

        public void addNode(int key) {
            if (!nodes.containsKey(key))
                this.nodes.put(key, new Node(key));
        }
    }

    /**
     * Customized KV Elem.
     */
    static class KVElem {
        String key;
        String value;

        public KVElem(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("num: %s, freq: %s", key, value);
        }
    }

    static class StaticInnerClass {
        private int a;

        public StaticInnerClass() {
        }
    }

    class InnerClass {
        private int b;

        public InnerClass() {
        }
    }
}

package com.jason.linkedlist;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Problem: 146
 * Difficulty: Medium
 * Very valuable problem.
 * This is my own version. The combination of HashMap and Doubly-LinkedList can reach the O(1) get and put.
 * O(1) put is impossible for like TreeMap(Red-black Tree) or PriorityQueue(min/max heap), which is all O(log(n)).
 */
public class LRUCache {
    DoublyListNode head;
    DoublyListNode tail;

    int capacity;

    HashMap<Integer, DoublyListNode> map;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }


    /**
     * If put when at capacity, remove the node from Doubly LinkedList and add at the first.
     *
     * @param key
     */
    private DoublyListNode removeNode(int key) {
        DoublyListNode removedNode = this.map.remove(key);
        if (removedNode == this.head && removedNode == this.tail) {
            // do nothing
        } else if (removedNode == head) {
            DoublyListNode next = removedNode.next;
            next.previous = null;
            removedNode.next = null;
            this.head = next;
        } else if (removedNode == tail) {
            DoublyListNode previous = removedNode.previous;
            previous.next = null;
            removedNode.previous = null;
            this.tail = previous;
        } else {
            DoublyListNode previous = removedNode.previous;
            DoublyListNode next = removedNode.next;
            previous.next = next;
            next.previous = previous;
        }

        return removedNode;
    }

    private void addFirst(DoublyListNode node) {
        if (map.isEmpty()) {
            this.head = node;
            this.tail = node;
//            map.put(node.key, node);
        } else {
            DoublyListNode oldHead = this.head;
            oldHead.previous = node;
            node.next = oldHead;
            node.previous = null;
            this.head = node;
//            map.put(node.key, node);
        }
        this.map.put(node.key, node);
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            DoublyListNode removed = removeNode(key);
            addFirst(removed);
            return removed.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DoublyListNode node = new DoublyListNode(key, value, null, null);
        if (this.map.containsKey(key)) {
            removeNode(key);
            addFirst(node);
        } else {
            if (this.map.size() == this.capacity) {
                // when at capacity, remove the tail. tail is LRU.
                removeNode(this.tail.key);
                addFirst(node);
            } else {
                addFirst(node);
            }
        }
    }

    static class DoublyListNode {
        int key;
        int value;

        DoublyListNode previous;
        DoublyListNode next;

        DoublyListNode(int key, int val, DoublyListNode previous, DoublyListNode next) {
            this.key = key;
            this.value = val;
            this.previous = previous;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(2));    // return 2
        lRUCache.put(1, 1);
        lRUCache.put(4, 1); // LRU key was 4, evicts key 2, cache is {4=1, 1=1}
        System.out.println(lRUCache.get(2));    // return -1 (not found)
    }
}

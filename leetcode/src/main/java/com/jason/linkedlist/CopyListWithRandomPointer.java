package com.jason.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 138
 * Difficulty: Medium
 * The purpose of the problem in the current editor is to create a clone of a linked list where each node contains
 * a random pointer, which could point to any node in the linked list or null.
 */
public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node curNode = head;
        Node prevNode = null;
        Node newHead = null;
        Map<Node, Node> map = new HashMap<>();
        while (curNode != null) {
            Node newNode = new Node(curNode.val);
            if (newHead == null) {
                newHead = newNode;
            }
            if (prevNode != null) {
                prevNode.next = newNode;
            }
            map.put(curNode, newNode);
            prevNode = newNode;
            curNode = curNode.next;
        }

        for (Node cur : map.keySet()) {
            Node newRandomNode = map.get(cur.random);
            map.get(cur).random = newRandomNode;
        }

        return newHead;
    }
}

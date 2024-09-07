package com.jason.linkedlist;

/**
 * Problem: 206
 * Difficulty: Easy
 * When we want to switch the direction of ListNode, we need two temp nodes to store the temp information.
 * Here in are prev node and next node.
 */
public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Temp node
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // temp node.
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

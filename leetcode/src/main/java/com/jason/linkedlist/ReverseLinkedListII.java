package com.jason.linkedlist;

/**
 * Problem: 92
 * Difficulty: Medium
 * The purpose of the problem is to reverse a sub-section of a linked list between given positions,
 * left and right, while leaving the rest of the list unchanged.
 */
public class ReverseLinkedListII {
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

    /**
     * This problem takes me a lots of time to debug.
     * Too many pointers might lose to connect.
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        int counter = 1;
        while (cur != null && counter != left) {
            prev = cur;
            cur = cur.next;
            counter++;
        }
        if (cur == null) return head;

        ListNode prevHead = prev;
        ListNode newTail = cur;
        ListNode next;
        prev = null;
        while (cur != null && counter != right) {
            next = cur.next;
            if (prev != null)
                cur.next = prev;
            prev = cur;
            cur = next;
            counter++;
        }
        ListNode newHead = cur;
        newTail.next = newHead.next;
        newHead.next = prev;
        if (prevHead != null) {
            prevHead.next = newHead;
        } else {
            head = newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode tc1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode tc2 = new ListNode(3, new ListNode(5));


        new ReverseLinkedListII().reverseBetween(tc1, 1,2);
    }
}

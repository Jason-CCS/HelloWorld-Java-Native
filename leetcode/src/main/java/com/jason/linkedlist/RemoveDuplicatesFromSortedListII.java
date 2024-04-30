package com.jason.linkedlist;

/**
 * Problem: 82
 * Difficulty: Medium
 * The purpose of the problem is to remove all nodes from a sorted linked list that have
 * duplicate values, such that only nodes with distinct values remain.
 */
public class RemoveDuplicatesFromSortedListII {
    public static class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (next != null && next.val == cur.val) {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }
            } else {
                prev = cur;
            }
            cur = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3)))));
//        new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
//        new RemoveDuplicatesFromSortedListII().deleteDuplicates(head2);
        new RemoveDuplicatesFromSortedListII().deleteDuplicates(head3);
    }
}

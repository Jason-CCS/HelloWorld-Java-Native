package com.jason.linkedlist;

/**
 * Problem: 61
 * Difficulty: Medium
 */
public class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode tail = null;
        int n = 0;
        while (cur != null) {
            if (cur.next == null) {
                tail = cur;
            }
            cur = cur.next;
            n++;
        }

        int rotateRight = k % n;
        int rotateLeft = n - rotateRight;
        // rotateLeft
        while (rotateLeft > 0) {
            tail.next = head;
            ListNode next = head.next;
            head.next = null;
            tail = head;
            head = next;
            rotateLeft--;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new RotateList().rotateRight(head, 5);
    }
}

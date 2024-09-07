package com.jason.linkedlist;

import java.util.ArrayList;

/**
 * Problem: 19
 * Difficulty: Medium
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * My approach is using a ArrayList to store the node, and use a counter to count from the tail.
     * Get(count-n-1).next = Get(count-n+1)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        ListNode current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            nodeList.add(current);
            count++;
        }

        ListNode previous = null;
        ListNode next = null;
        int previousIndex = count - n - 1;
        int nextIndex = count - n + 1;

        if (previousIndex < 0 && nextIndex >= count)
            return null; // when you don't have the previous and the next of the removing node.
        else if (previousIndex < 0)
            return nodeList.get(nextIndex); // when you are removing the head.
        else if (nextIndex >= count)
            nodeList.get(previousIndex).next = null; // when you are removing the tail.
        else
            nodeList.get(previousIndex).next = nodeList.get(nextIndex);

        return nodeList.get(0);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return head;
        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodeList.add(curr);
            curr = curr.next;
        }

        int prevIdx = nodeList.size() - n - 1;
        int nextIdx = nodeList.size() - n + 1;
        ListNode prev = (prevIdx < 0) ? null : nodeList.get(prevIdx);
        ListNode next = (nextIdx > nodeList.size() - 1) ? null : nodeList.get(nextIdx);
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        return head;
    }

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

    public static void main(String[] args) {

    }
}

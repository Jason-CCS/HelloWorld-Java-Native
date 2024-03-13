package com.jason.linkedlist;

import java.util.ArrayList;

/**
 * Problem: 141
 * Difficulty: Easy
 * This problem is an Easy problem, but I spend a lot of time to think of the solution.
 * However, I didn't think of that I can change its original value to make it visited.
 *
 * Another way is use the way to write Tortoise and Hare game.
 * Hare will anyway chase up to the Tortoise, and that means it is cycle linked list.
 */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode current = head;
        head.val = 100001;
        while (current.next != null) {
            if (current.next.val == 100001) {
                return true;
            } else {
                current = current.next;
                current.val = 100001;
            }
        }

        return false;
    }


    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(head));
    }
}

package com.jason.linkedlist;

import java.util.ArrayList;

/**
 * Problem: 141
 * Difficulty: Easy
 * This problem is an Easy problem, but I spend a lot of time to think of the solution.
 * However, I didn't think of that I can change its original value to make it visited.
 * <p>
 * Another way is use the way to write Tortoise and Hare game.
 * Hare will anyway chase up to the Tortoise, and that means it is cycle linked list.
 */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode curr = head;
        while (curr != null) {
            // visit
            if (curr.val == 100001) {
                return true;
            } else {
                curr.val = 100001;
                curr = curr.next;
            }
        }

        return false;
    }

    /**
     * 龜兔賽跑 approach
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)
                return true;
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

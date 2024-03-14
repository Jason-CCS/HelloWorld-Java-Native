package com.jason.divide_and_conquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Problem: 148
 * Difficulty: Medium
 * I didn't use divide and conquer because this problem seems to be too difficult by the forum.
 * And I don't want to waste time to figure out how to use divide and conquer on linked list.
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode node = head;
        ArrayList<ListNode> arrayList = new ArrayList<>();


        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            arrayList.add(node);
            node = next;
        }

        arrayList.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode curNode = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            curNode.next = arrayList.get(i);
            curNode = curNode.next;
        }

        return arrayList.get(0);
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
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        head = sortList(head);
        System.out.println();
    }
}

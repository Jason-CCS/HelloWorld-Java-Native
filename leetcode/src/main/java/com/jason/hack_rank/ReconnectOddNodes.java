package com.jason.hack_rank;

public class ReconnectOddNodes {

    /**
     * O(2n) = O(n)
     * @param head
     * @return
     */
    public static SinglyLinkedListNode filterOddNodes(SinglyLinkedListNode head) {
        if (head == null) return null; // if the head is null, return null

        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode newTail = null;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode oldHead = null;

        int position = 1;
        while (head != null) {
            if (position % 2 == 1) { // odd position
                if (newHead == null) {
                    newHead = head;
                    newTail = head;
                } else {
                    newTail.next = head;
                    newTail = head;
                }
                // delete node from the old linked list
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = head.next;
                    head = head.next;
                }
            } else {
                if (oldHead == null) {
                    oldHead = head;
                }
                prev = head;
                head = head.next;
            }
            position++;
        }

        newTail.next = filterOddNodes(oldHead);

        return newHead;
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(filterOddNodes(new SinglyLinkedListNode(3, new SinglyLinkedListNode(5, new SinglyLinkedListNode(3, new SinglyLinkedListNode(7, new SinglyLinkedListNode(8, null)))))));
    }
}

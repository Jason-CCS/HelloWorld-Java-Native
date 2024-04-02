package com.jason.hack_rank;


public class MergeTwoSortedLinkedLists {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode headNode = null;
        SinglyLinkedListNode prevNode = null;
        while (head1 != null && head2 != null) {
            SinglyLinkedListNode curNode;
            if (head1.data <= head2.data) {
                curNode = new SinglyLinkedListNode(head1.data);
                head1 = head1.next;
            } else {
                curNode = new SinglyLinkedListNode(head2.data);
                head2 = head2.next;
            }
            if (headNode == null) {
                headNode = curNode;
                prevNode = headNode;
            } else {
                prevNode.next = curNode;
                prevNode = curNode;
            }
        }

        if (head1 != null) {
            if (prevNode == null) {
                headNode = head1;
            } else {
                prevNode.next = head1;
            }
        }

        if (head2 != null) {
            if (prevNode == null) {
                headNode = head2;
            } else {
                prevNode.next = head2;
            }
        }

        return headNode;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.next = new SinglyLinkedListNode(3);
        head1.next.next = new SinglyLinkedListNode(7);
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.next = new SinglyLinkedListNode(2);

        SinglyLinkedListNode result = mergeLists(head1, head2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

}

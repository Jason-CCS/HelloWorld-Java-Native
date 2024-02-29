package com.jason.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list2 == null) {
            return list1;
        } else if (list1 == null){
            return list2;
        } else {
            ListNode resultNode = null;
            ListNode curNode = new ListNode();
            while (list1 != null && list2 != null) {
                int curVal = 0;
                if (list1.val <= list2.val) {
                    curVal = list1.val;
                    list1 = list1.next;
                } else {
                    curVal = list2.val;
                    list2 = list2.next;
                }
                if (resultNode == null) {
                    resultNode = new ListNode(curVal);
                    curNode = resultNode;
                } else {
                    curNode.next = new ListNode(curVal);
                    curNode = curNode.next;
                }
            }
            if (list1 != null)
                curNode.next = list1;
            else
                curNode.next = list2;
            return resultNode;
        }
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
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode resultNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);

        ListNode list3 = null;
        ListNode list4 = null;
        ListNode resultNode2 = new MergeTwoSortedLists().mergeTwoLists(list3, list4);

        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode resultNode3 = new MergeTwoSortedLists().mergeTwoLists(list5, list6);
        System.out.println();
    }
}

package com.jason;

/**
 * recursive的寫法簡潔，但是可讀性比較差。
 * 程式的寫法如果可以就是盡量有需要才跑下一行，那麼可以少掉很多執行的時間。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
        int carry = sum / 10;
        if (carry == 1) {
            return new ListNode(sum % 10, addTwoNumbers(new ListNode(carry),
                    addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next)));
        } else {
            return new ListNode(sum % 10, addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next));
        }
    }

    private static class ListNode {
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
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9);
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        do {
            System.out.print(result.val + ",");
            result = result.next;
        } while (result != null);
    }
}

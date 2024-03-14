package com.jason.heap;

public class SellProductsForMaxProfit {

    public static int maxProfit(int order, int[] inventory) {
        // make a maxHeap
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < inventory.length; i++) {
            TreeNode node = new TreeNode(inventory[i]);
            maxHeap.insertNode(node);
            System.out.println(maxHeap.heapList);
        }

        int maxProfit = 0;
        while (order != 0) {
            int val = maxHeap.getRoot().val;
            maxProfit = maxProfit + val;
            maxHeap.updateRoot(val - 1);
            System.out.println(maxHeap.heapList.toString());
            order--;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
//        System.out.println(maxProfit(6, new int[]{2, 5, 7, 9, 3}));
        System.out.println(maxProfit(6, new int[]{3,3,4,4,3}));
    }
}

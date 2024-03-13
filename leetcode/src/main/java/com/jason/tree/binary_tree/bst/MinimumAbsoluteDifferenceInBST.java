package com.jason.tree.binary_tree.bst;

import java.util.*;

/**
 * Problem: 530
 * Difficulty: Easy
 */
public class MinimumAbsoluteDifferenceInBST {

    /**
     * I use the PriorityQueue to maintain the sorted condition.
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        dfs(root, heap);

        int min = Integer.MAX_VALUE;
        int previous = heap.poll();
        while (!heap.isEmpty()) {
            int current = heap.poll();
            min = Math.min(min, current - previous);
            previous = current;
        }

        return min;
    }

    public static void dfs(TreeNode node, PriorityQueue<Integer> heap) {
        if (node != null) {
            heap.offer(node.val);
            dfs(node.left, heap);
            dfs(node.right, heap);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

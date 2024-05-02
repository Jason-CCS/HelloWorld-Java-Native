package com.jason.tree.binary_tree;

/**
 * Problem: 129
 * Difficulty: Medium
 * The purpose of the problem is to calculate the sum of all root-to-leaf numbers represented by the path,
 * where each path forms an integer by concatenating their node values in top-to-down order.
 */
public class SumRootToLeafNumbers {
    /**
     * DFS + DP
     * Use preSum as DP.
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) return 0;
        // visit
        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return preSum;
        }
        // traverse
        return dfs(root.left, preSum) + dfs(root.right, preSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}

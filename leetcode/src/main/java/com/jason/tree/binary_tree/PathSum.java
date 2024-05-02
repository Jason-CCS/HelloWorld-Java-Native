package com.jason.tree.binary_tree;

/**
 * Problem: 112
 * Difficulty: Easy
 * The purpose of the problem is to determine if the binary tree has a root-to-leaf path
 * such that adding up all the values along the path equals a specified target sum.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);
    }
}

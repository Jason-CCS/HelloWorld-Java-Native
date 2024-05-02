package com.jason.tree.binary_tree;

/**
 * Problem: 222
 * Difficulty: Easy
 * The purpose of the problem is to count the total number of nodes in a complete binary tree.
 */
public class CountCompleteTreeNodes {
    public int depth = 0;
    public int leaves = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return  (int)Math.pow(2, depth - 1) - 1 + leaves;
    }

    public boolean dfs(TreeNode root, int h) {
        if (root != null) {
            h++;
            if (root.left == null && root.right == null) {
                if (h >= depth) {
                    depth = h;
                    leaves++;
                    return true;
                } else {
                    return false;
                }
            }
            return dfs(root.left, h) && dfs(root.right, h);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        new CountCompleteTreeNodes().countNodes(root);
    }
}

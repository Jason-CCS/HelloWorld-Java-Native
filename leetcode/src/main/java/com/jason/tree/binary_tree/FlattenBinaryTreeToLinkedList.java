package com.jason.tree.binary_tree;

/**
 * Problem: 114
 * Difficulty: Medium
 * The purpose of the problem is to flatten a binary tree to a linked list in-place following the preorder traversal order.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        root = preorder(root);
    }

    private TreeNode preorder(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // visit
        root.left = null;
        root.right = preorder(left);
        if (root.right == null) {
            root.right = preorder(right);
        } else {
            TreeNode rightest = root.right;
            while (rightest.right != null) {
                rightest = rightest.right;
            }
            rightest.right = preorder(right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        new FlattenBinaryTreeToLinkedList().flatten(root);
    }
}

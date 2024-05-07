package com.jason.tree.binary_tree.bst;

import com.jason.tree.binary_tree.TreeNode;

/**
 * Problem: 98
 * Difficulty: Medium
 * The purpose of the problem is to determine if a given binary tree is a valid binary search tree (BST).
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return preorder(root, null, null);
    }

    private boolean preorder(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        // visit
        if (root.left != null) {
            if (root.left.val >= root.val)
                return false;
            if (min != null && root.left.val <= min)
                return false;
        }
        if (root.right != null) {
            if (root.right.val <= root.val)
                return false;
            if (max != null && root.right.val >= max)
                return false;
        }

        return preorder(root.left, min, root.val) && preorder(root.right, root.val, max);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}

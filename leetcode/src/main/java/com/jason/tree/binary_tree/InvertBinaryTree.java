package com.jason.tree.binary_tree;

/**
 * Problem: 226
 * Difficulty: Easy
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }

//    public TreeNode invert(TreeNode p, TreeNode q) {
//        if (p != null && q != null) {
//            if (p.val != q.val)
//                return false;
//            else {
//                if (!invert(p.left, q.right))
//                    return false;
//                if (!invert(p.right, q.left))
//                    return false;
//            }
//        } else if (p == null && q == null) {
//            return true;
//        } else {
//            return false;
//        }
//        return true;
//    }

    public class TreeNode {
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

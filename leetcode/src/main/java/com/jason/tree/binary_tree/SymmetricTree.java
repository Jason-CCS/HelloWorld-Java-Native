package com.jason.tree.binary_tree;

/**
 * Problem: 101
 * Difficulty: Easy
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    public boolean isSymmetric(TreeNode p, TreeNode q){
        if (p != null && q != null) {
            if (p.val != q.val)
                return false;
            else {
                if (!isSymmetric(p.left, q.right))
                    return false;
                if (!isSymmetric(p.right, q.left))
                    return false;
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
        return true;
    }

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

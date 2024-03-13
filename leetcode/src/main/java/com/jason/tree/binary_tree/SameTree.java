package com.jason.tree.binary_tree;

/**
 * Problem: 100
 * Difficulty: Easy
 * DFS use recursive. BFS use queue.
 */
public class SameTree {

    /**
     * Pre-order traversal. visit node, then node.left, then node.right.
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val)
                return false;
            else {
                if (!isSameTree(p.left, q.left))
                    return false;
                if (!isSameTree(p.right, q.right))
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

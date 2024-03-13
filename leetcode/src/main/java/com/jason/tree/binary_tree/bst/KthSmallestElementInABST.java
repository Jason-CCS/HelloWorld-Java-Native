package com.jason.tree.binary_tree.bst;

/**
 * Problem: 230
 * Difficulty: Medium
 */
public class KthSmallestElementInABST {
    public static int kElement = -1;

    /**
     * The first version. Beats 100% users.
     * we can traverse the tree with some extra parameters to synchronize the value among different visits.
     * Here this example I pass in the k into the dfs, and decrease it when visiting.
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrderDFS(root, k);
        return kElement;
    }

    public int inOrderDFS(TreeNode node, int k) {
        if (node != null) {
            if (k > 0)
                k = inOrderDFS(node.left, k);
            // visit part
            if (k > 0)
                k = k - 1;
            if (k == 0) {
                kElement = node.val;
                k = -1;
            }
            // end visit
            if (k > 0)
                k = inOrderDFS(node.right, k);
        }
        return k;
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

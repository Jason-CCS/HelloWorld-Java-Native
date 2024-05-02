package com.jason.tree.binary_tree;

/**
 * Problem: 105
 * Difficulty: Medium
 * The purpose of the problem is to construct a binary tree from given preorder and inorder traversal arrays.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int p = 0;
    private int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length)
            return null;
        if (inorder[i] == stop) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[p]);
        p++;
        // "root.val": preorder left node should stop growing when root.val == inorder[i] since inorder has stopped growing at inorder[i]
        root.left = build(preorder, inorder, root.val);
        // "stop": preorder right node should stop growing when the nearest ancestor came from left branch
        // since that nearest ancestor is the next traversal node for inorder traversal when the current node has no right child.
        root.right = build(preorder, inorder, stop);
        return root;
    }
}

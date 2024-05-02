package com.jason.tree.binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: 102
 * Difficulty: Medium
 * The purpose of the problem is to return the level-by-level node values of a binary tree in an ordered list.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curCounter = 1, nextCounter = 0, level = 0;
        res.add(new LinkedList<>());
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // visit
            curCounter--;
            res.get(level).add(node.val);
            // traverse
            if (node.left != null) {
                queue.offer(node.left);
                nextCounter++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextCounter++;
            }
            if (curCounter == 0 && !queue.isEmpty()) {
                level++;
                res.add(level, new LinkedList<>());
                curCounter = nextCounter;
                nextCounter = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}

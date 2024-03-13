package com.jason.tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: 109
 * Difficulty: Medium
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> rightSideView = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            rightSideView.add(curNode.val);
            if (curNode.right != null) {
                queue.offer(curNode.right);
            } else {
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
            }
        }

        return rightSideView;
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

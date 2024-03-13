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
    /**
     * Time Complexity: O(n)
     * I use BFS and visit right first to make sure the element polled from queue is first visited.
     * So only when the level of each node is greater than viewedLevel, than it means it is first seen element from the right side.
     * Everytime when the element is seen from the right side, we have to add into the viewedList and also update the viewedLevel.
     * This is my solution. Seems the result is okay. Beats 68% users.
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> viewedList = new ArrayList<>();
        if (root == null) return viewedList;

        Queue<LevelTreeNode> queue = new LinkedList<>();
        queue.offer(new LevelTreeNode(root.val, 1, root.left, root.right));

        int viewedLevel = 0;
        while (!queue.isEmpty()) {
            LevelTreeNode curNode = queue.poll();
            if (curNode.level > viewedLevel) {
                viewedList.add(curNode.val);
                viewedLevel++;
            }
            if (curNode.right != null) {
                queue.offer(new LevelTreeNode(curNode.right.val, curNode.level + 1, curNode.right.left, curNode.right.right));
            }
            if (curNode.left != null) {
                queue.offer(new LevelTreeNode(curNode.left.val, curNode.level + 1, curNode.left.left, curNode.left.right));
            }
        }

        return viewedList;
    }

    public static class LevelTreeNode extends TreeNode {
        int level;

        LevelTreeNode(int val, int level, TreeNode left, TreeNode right) {
            super(val, left, right);
            this.level = level;
        }
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(4));
        System.out.println(rightSideView(root));
    }
}

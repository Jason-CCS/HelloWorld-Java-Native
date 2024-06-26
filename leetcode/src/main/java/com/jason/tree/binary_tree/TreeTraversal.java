package com.jason.tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class TreeTraversal {

    /**
     * Pre-order, root first
     *
     * @param root
     */
    public static void dfs(TreeNode root, VisitFunction<Integer> visitFunction) {
        if (root == null) return;

        // visit parent first
        visitFunction.test(root.val);
        dfs(root.left, visitFunction);
        dfs(root.right, visitFunction);
    }

    public static abstract class VisitFunction<Integer> implements Predicate<Integer> {

        @Override
        abstract public boolean test(Integer value);
    }

    /**
     * Pre-order, root first
     *
     * @param root
     */
    public static void bfs(TreeNode root, VisitFunction<Integer> visitFunction) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            visitFunction.test(curNode.val);
            if (curNode.left!=null) queue.offer(curNode.left);
            if (curNode.right!=null) queue.offer(curNode.right);
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

    }
}

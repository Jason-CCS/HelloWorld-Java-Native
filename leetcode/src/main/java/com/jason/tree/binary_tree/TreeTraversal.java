package com.jason.tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;
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
        visitFunction.apply(root.val);
        dfs(root.left, visitFunction);
        dfs(root.right, visitFunction);
    }

    public static class VisitFunction<Integer> implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer integer) {
            return null;
        }
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
            visitFunction.apply(curNode.val);
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

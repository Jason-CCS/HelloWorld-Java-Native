package com.jason.tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> sumList = new ArrayList<>();
        ArrayList<Integer> nodeCount = new ArrayList<>();
        Queue<LevelTreeNode> queue = new LinkedList<>();
        queue.add(new LevelTreeNode(root, 0));

        while (!queue.isEmpty()) {
            LevelTreeNode curNode = queue.poll();
            int curLevel = curNode.level;
            int curVal = curNode.node.val;
            if (curLevel > sumList.size() - 1) {
                sumList.add((double) curVal);
                nodeCount.add(1);
            } else {
                sumList.set(curLevel, sumList.get(curLevel) + curVal);
                nodeCount.set(curLevel, nodeCount.get(curLevel) + 1);
            }
            if (curNode.node.left != null)
                queue.add(new LevelTreeNode(curNode.node.left, curLevel + 1));
            if (curNode.node.right != null)
                queue.add(new LevelTreeNode(curNode.node.right, curLevel + 1));
        }

        List<Double> avgOfLevels = new ArrayList<>();
        for (int i = 0; i < sumList.size(); i++) {
            avgOfLevels.add(sumList.get(i) / nodeCount.get(i));
        }
        return avgOfLevels;
    }

    public static class LevelTreeNode {
        TreeNode node;
        int level;

        public LevelTreeNode(TreeNode node, int level) {
            this.node = node;
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
        TreeNode root = new TreeNode(2147483647, new TreeNode(2147483647), new TreeNode(2147483647));
        System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(root));
    }
}

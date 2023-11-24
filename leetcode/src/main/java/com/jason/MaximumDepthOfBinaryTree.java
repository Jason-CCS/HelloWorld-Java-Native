package com.jason;

/**
 * To practice Binary Tree and DFS.
 */
public class MaximumDepthOfBinaryTree {
    private int maxLevel = 0;

    public int maxDepth(TreeNode root) {
        // write a DFS algo
        dfs(root, 0);
        return maxLevel;
    }

    public void dfs(TreeNode node, int currentLevel) {
        if (node == null)
            return;
        currentLevel += 1;
        if (currentLevel > maxLevel) {
            maxLevel = currentLevel;
        }
        if (node.left != null)
            dfs(node.left, currentLevel);
        if (node.right != null)
            dfs(node.right, currentLevel);
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
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(6), null), new TreeNode(5)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root3 = null;
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root2));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root3));
    }
}

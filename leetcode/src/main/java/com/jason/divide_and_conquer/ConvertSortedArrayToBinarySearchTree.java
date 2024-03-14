package com.jason.divide_and_conquer;


/**
 * Problem: 108
 * Difficulty: Easy
 * Topic: binary search to create a BST
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * This is the solution from LeetCode solution.
     * I don't know how to build a balanced tree from an array.
     * The very 5 stars concept here: !!!!!!!!!!
     * When you do the binary search for a sorted array, you can at the same time build up a binary search tree.
     * It will take n*log(n) time to create.
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private static TreeNode createBST(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBST(nums, l, mid - 1);
        node.right = createBST(nums, mid + 1, r);
        return node;
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
        int[] tc1={-10,-3,0,5,9};
        int[] tc2={1,3};

        TreeNode root = sortedArrayToBST(tc1);
        TreeNode root2 = sortedArrayToBST(tc2);
    }
}

package com.jason.tree.binary_tree.heap;

public class TreeNode {
    int index;
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(){

    }

    public TreeNode(int val) {
        this.val = val;
        this.parent = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.left.parent = this;
        this.right.parent = this;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    public int getVal(){
        return this.val;
    }
}

package com.jason.heap;

import java.util.ArrayList;

public class MaxHeap {
    TreeNode root;
    int level;
    ArrayList<TreeNode> heapList = new ArrayList<>();

    public MaxHeap() {
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void insertNode(TreeNode node) {
        if (this.isEmpty()) {
            node.index = 0;
            this.root = node;
            heapList.add(node);
        } else {
            node.index = heapList.size();
            heapList.add(node);
            TreeNode parent = getParent(node.index);
            if (node.index % 2 == 1) { // left
                parent.left = node;
            } else { // right
                parent.right = node;
            }
            node.parent = parent;
            bubbleUp(node);
        }
    }

    public void updateRoot(int val) {
        this.root.val = val;
        if ((this.root.left != null && this.root.left.val > this.root.val) || (this.root.right != null && this.root.right.val > this.root.val))
            bubbleDown(this.root);
    }

    public TreeNode removeRoot() {
        TreeNode root = this.root;
        int rootIndex = root.index;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;

        TreeNode last = heapList.remove(heapList.size() - 1);
        int lastIndex = last.index;
        TreeNode theParentOfLast = last.parent;
        if (lastIndex % 2 == 1) { // left
            theParentOfLast.left = null;
        } else { // right
            theParentOfLast.right = null;
        }

        last.index = rootIndex;
        last.parent = null;
        last.left = leftChild;
        last.right = rightChild;
        this.root = last;

        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private TreeNode getParent(int childIndex) {
        TreeNode parent;
        if (childIndex % 2 == 1) {// left
            parent = heapList.get((childIndex - 1) / 2);
        } else { // right
            parent = heapList.get((childIndex - 2) / 2);
        }
        return parent;
    }

    private TreeNode swapUp(TreeNode srcNode, TreeNode destNode) {
        if (destNode == this.root)
            this.root = srcNode;
//        TreeNode srcParent = sourceNode.parent;
        TreeNode srcLeft = srcNode.left;
        TreeNode srcRight = srcNode.right;
        TreeNode destParent = destNode.parent;
        if (destNode.parent != null) {
            if (destNode == destParent.left) {
                destParent.left = srcNode;
            } else {
                destParent.right = srcNode;
            }
        }
        TreeNode destLeft = destNode.left;
        TreeNode destRight = destNode.right;
        if (srcNode == destNode.left) {
            srcNode.left = destNode;
            srcNode.right = destRight;
            if (destRight != null)
                destRight.parent = srcNode;
        } else {
            srcNode.left = destLeft;
            srcNode.right = destNode;
            destLeft.parent = srcNode;
        }
        srcNode.parent = destParent;
        destNode.parent = srcNode;
        destNode.left = srcLeft;
        if (srcLeft != null) {
            srcLeft.parent = destNode;
        }
        destNode.right = srcRight;
        if (srcRight != null) {
            srcRight.parent = destNode;
        }

        return srcNode;
    }

    private TreeNode swapDown(TreeNode srcNode, TreeNode destNode) {
        if (srcNode == this.root)
            this.root = destNode;
        TreeNode srcParent = srcNode.parent;
        if (srcParent != null) {
            if (srcNode == srcParent.left) {
                srcParent.left = destNode;
            } else {
                srcParent.right = destNode;
            }
        }
        TreeNode srcLeft = srcNode.left;
        TreeNode srcRight = srcNode.right;
//        TreeNode destParent = destNode.parent;
        TreeNode destLeft = destNode.left;
        TreeNode destRight = destNode.right;
        if (destNode == srcNode.left) {
            destNode.left = srcNode;
            destNode.right = srcRight;
            if (srcRight != null)
                srcRight.parent = destNode;
        } else {
            destNode.left = srcLeft;
            destNode.right = srcNode;
            srcLeft.parent = destNode;
        }
        srcNode.parent = destNode;
        srcNode.left = destLeft;
        if (destLeft != null) {
            destLeft.parent = srcNode;
        }
        srcNode.right = destRight;
        if (destRight != null) {
            destRight.parent = srcNode;
        }
        destNode.parent = srcParent;


        return srcNode;
    }

    private void swapInHeapList(TreeNode srcNode, TreeNode destNode) {
        int srcIndex = srcNode.index;
        int destIndex = destNode.index;
        srcNode.index = destIndex;
        destNode.index = srcIndex;
        heapList.set(srcIndex, destNode);
        heapList.set(destIndex, srcNode);
    }

    private void bubbleUp(TreeNode theNode) {
        // do swap with parent
        if (theNode != root && theNode.parent.val < theNode.val) {
            TreeNode parentNode = theNode.parent;
            swapInHeapList(theNode, parentNode);
            TreeNode resultNode = swapUp(theNode, parentNode);
            bubbleUp(resultNode);
        }
    }

    private void bubbleDown(TreeNode theNode) {
        if (theNode != null) {
            TreeNode resultNode = null;
            // do swap with left or right
            if (theNode.left != null && theNode.right != null) {
                if (theNode.right.val > theNode.val && theNode.right.val > theNode.left.val) {
                    TreeNode rightNode = theNode.right;
                    swapInHeapList(theNode, rightNode);
                    resultNode = swapDown(theNode, rightNode);
                } else if (theNode.left.val > theNode.val) {
                    TreeNode leftNode = theNode.left;
                    swapInHeapList(theNode, leftNode);
                    resultNode = swapDown(theNode, leftNode);
                }
            } else if (theNode.left != null && theNode.left.val > theNode.val) {
                TreeNode leftNode = theNode.left;
                swapInHeapList(theNode, leftNode);
                resultNode = swapDown(theNode, leftNode);
            } else {
                // no children, do nothing
            }
            bubbleDown(resultNode);
        }
    }
}

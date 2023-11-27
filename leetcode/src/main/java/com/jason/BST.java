package com.jason;

/**
 * HackRank
 */
public class BST {
    private static int isPresent(Node root, int val) {
        while (root.data != val) {
            if (val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
            if (root == null){
                return 0;
            }
        }
        return 1;
    }

    class Node {
        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    public static void main(String[] args) {

    }

}

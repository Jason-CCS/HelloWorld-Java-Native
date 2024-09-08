package com.jason.hack_rank;

/**
 * This practice teaches me how to do Huffman coding.
 * It uses binary tree to code the string.
 */
public class HuffmanCoding {
    void decode(String s, Node root) {
        Node curr = root;
        int idx = 0;
        while (idx < s.length()) { // O(n), n is s.length.
            if(s.charAt(idx)=='0')
                curr = curr.left;
            else
                curr = curr.right;
            if(curr.left==null && curr.right==null) {
                System.out.print(curr.data);
                curr = root;
            }
            idx++;
        }
    }

    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }
}

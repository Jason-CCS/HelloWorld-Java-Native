package com.jason.tree.trie;

/**
 * Problem: 208
 * Difficulty: Medium
 * The current problem is to implement a Trie (Prefix Tree), a tree-like data structure that is used to efficiently store and retrieve keys in a dataset of strings.
 * This data structure is useful for the applications, such as autocomplete and spellchecker.
 */
public class Trie {
    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child == null) {
                child = new TrieNode();
                current.setChild(ch, child);
            }
            current = child;
        }

        current.setEndOfWord(true);
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord();
    }

    // Method to check if a prefix exists in the Trie
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    // Helper method to search for a node corresponding to a given word
    private TrieNode searchNode(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child == null) {
                return null; // The node for the word doesn't exist
            }
            current = child;
        }

        return current;
    }

    protected static class TrieNode {
        // Number of possible characters (26 for lowercase English letters)
        private static final int ALPHABET_SIZE = 26;

        // Array to store child nodes
        private TrieNode[] children;

        // Flag to indicate whether the current node represents the end of a word
        private boolean isEndOfWord;

        // Constructor
        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
        }

        // Getter and setter methods for isEndOfWord
        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        // Method to get the child node for a specific character
        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        // Method to set the child node for a specific character
        public void setChild(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

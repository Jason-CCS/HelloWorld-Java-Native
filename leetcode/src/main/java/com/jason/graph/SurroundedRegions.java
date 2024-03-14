package com.jason.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Problem: 130
 * Difficulty: Medium
 * The first version.
 */
public class SurroundedRegions {
    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Node[][] matrix = new Node[m][n];
        HashMap<Node, LinkedList<Node>> oGraph = new HashMap<>();

        /**
         * create the Node matrix
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Node(i, j, board[i][j]);
            }
        }

        /**
         * create the graph having the directed relationship
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    oGraph.put(matrix[i][j], checkAdjacency(i, j, matrix, m, n));
                }
            }
        }

        /**
         * dfs for the nodes at boundary lines and make them visited.
         * and finally remove them.
         */
        for (int i = 0, j = 0; j < n; j++) {
            if (oGraph.containsKey(matrix[i][j])) {
                dfsAndRemove(matrix[i][j], oGraph);
            }
        }
        for (int i = m - 1, j = 0; j < n; j++) {
            if (oGraph.containsKey(matrix[i][j])) {
                dfsAndRemove(matrix[i][j], oGraph);
            }
        }
        for (int i = 0, j = 0; i < m; i++) {
            if (oGraph.containsKey(matrix[i][j])) {
                dfsAndRemove(matrix[i][j], oGraph);
            }
        }
        for (int i = 0, j = n - 1; i < m; i++) {
            if (oGraph.containsKey(matrix[i][j])) {
                dfsAndRemove(matrix[i][j], oGraph);
            }
        }

        for (Node node : oGraph.keySet()) {
            board[node.i][node.j] = 'X';
        }
    }

    static LinkedList<Node> checkAdjacency(int i, int j, Node[][] matrix, int m, int n) {
        LinkedList<Node> children = new LinkedList<>();
        if (i - 1 >= 0)
            if (matrix[i - 1][j].value == 'O')
                children.add(matrix[i - 1][j]);
        if (i + 1 != m)
            if (matrix[i + 1][j].value == 'O')
                children.add(matrix[i + 1][j]);
        if (j - 1 >= 0)
            if (matrix[i][j - 1].value == 'O')
                children.add(matrix[i][j - 1]);
        if (j + 1 != n)
            if (matrix[i][j + 1].value == 'O')
                children.add(matrix[i][j + 1]);

        return children;
    }

    static void dfsAndRemove(Node node, HashMap<Node, LinkedList<Node>> oGraph) {
        if (node.visited == false) {
            node.visited = true;
            for (Node child : oGraph.get(node)) {
                dfsAndRemove(child, oGraph);
            }
            oGraph.remove(node);
        }
    }

    static class Node {
        int i;
        int j;
        boolean visited = false;
        char value;

        public Node(int i, int j, char val) {
            this.i = i;
            this.j = j;
            this.value = val;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        char[][] board2 = {
                {'O', 'O'},
                {'O', 'O'}};
        solve(board2);
        for (int i = 0; i < board2.length; i++) {
            System.out.println(Arrays.toString(board2[i]));
        }

    }
}

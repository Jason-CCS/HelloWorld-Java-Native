package com.jason.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Problem: 130
 * Difficulty: Medium
 * Use a Node[][] matrix to store the board. In this way, I can make use of the visited property to make sure if the 'O'
 * is a potential descendant of boundary 'O'.
 */
public class SurroundedRegions2 {
    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Node[][] matrix = new Node[m][n];

        /**
         * create the Node matrix
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Node(i, j);
            }
        }

        /**
         * dfs for the nodes at boundary lines and make them visited
         */
        for (int i = 0, j = 0; j < n; j++) {
            if (board[i][j] == 'O')
                checkAdjacency(matrix[i][j], matrix, board, m, n);
        }
        for (int i = m - 1, j = 0; j < n; j++) {
            if (board[i][j] == 'O')
                checkAdjacency(matrix[i][j], matrix, board, m, n);
        }
        for (int i = 0, j = 0; i < m; i++) {
            if (board[i][j] == 'O')
                checkAdjacency(matrix[i][j], matrix, board, m, n);
        }
        for (int i = 0, j = n - 1; i < m; i++) {
            if (board[i][j] == 'O')
                checkAdjacency(matrix[i][j], matrix, board, m, n);
        }

        /**
         * iterate the nodes not in boundary and not visited, turn 'O' to 'X' if it is 'O'.
         */
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (matrix[i][j].visited == false && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    static void checkAdjacency(Node node, Node[][] matrix, char[][] board, int m, int n) {
        if (node.visited == false) {
            node.visited = true;
            if (node.i - 1 >= 0 && board[node.i - 1][node.j] == 'O')
                checkAdjacency(matrix[node.i - 1][node.j], matrix, board, m, n);
            if (node.i + 1 != m && board[node.i + 1][node.j] == 'O')
                checkAdjacency(matrix[node.i + 1][node.j], matrix, board, m, n);
            if (node.j - 1 >= 0 && board[node.i][node.j - 1] == 'O')
                checkAdjacency(matrix[node.i][node.j - 1], matrix, board, m, n);
            if (node.j + 1 != n && board[node.i][node.j + 1] == 'O')
                checkAdjacency(matrix[node.i][node.j + 1], matrix, board, m, n);
        }
    }

    static class Node {
        int i;
        int j;
        boolean visited = false;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
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

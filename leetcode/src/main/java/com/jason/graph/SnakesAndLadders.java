package com.jason.graph;

import java.util.*;

/**
 * Problem: 909
 * Difficulty: Medium
 */
public class SnakesAndLadders {
    private static int n = 0;

    /**
     * Version 1
     * Got TLE.
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int target = n * n;
        Node[] allNodes = new Node[target + 1];
        allNodes[0] = new Node(0, -1, -1); // set 0 as dummy node

        // build the nodes first
        int row;
        for (int i = 1; i <= n * n; i++) {
            row = getRow(i);
            allNodes[i] = new Node(i, row, getCol(row, i));
        }

        // build the graph next
        for (int i = 1; i <= n * n; i++) {
            Node currentNode = allNodes[i];
            int currentVal = currentNode.val;
            for (int j = currentVal + 1; j <= Math.min(currentVal + 6, n * n); j++) {
                Node nextNode = allNodes[j];
                if (board[nextNode.i][nextNode.j] != -1) {
                    nextNode = allNodes[board[nextNode.i][nextNode.j]];
                }
                currentNode.addNode(nextNode);
            }
        }

        // BFS the graph to find the shortest path from node 1 to node n^2
        Queue<Node> queue = new LinkedList<>();
        queue.offer(allNodes[1]);
        int moves = -1;
        while (!queue.isEmpty()) { // every layer
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                // visit
                if (cur != null) {
                    cur.visited = true;
                    if (cur.val == target)
                        return moves;
                    for (Node child : cur.children) {
                        if (!child.visited)
                            queue.offer(child);
                    }
                }
            }
        }

        return (allNodes[n * n].visited) ? moves : -1;
    }

    static class Node {
        int val;
        int i;
        int j;
        boolean visited;
        List<Node> children;

        public Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
            this.children = new ArrayList<>();
        }

        public void addNode(Node child) {
            this.children.add(child);
        }
    }

    private int getRow(int num) {
        return (n - 1) - (num - 1) / n;
    }

    private int getCol(int row, int num) {
        if (((n % 2) ^ (row % 2)) == 0)
            return (n - 1) - ((num - 1) % n);
        else
            return (num - 1) % n;
    }

    /**
     * Version 2 from internet
     * This version avoid the Node structure so that we don't have to waste time on building graph relationship.
     * @param board
     * @return
     */
    public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return moves;  // found the target
                }
                for (int j = current + 1; j <= Math.min(current + 6, n * n); j++) {
                    int[] rc = getRC(j, n);  // get the row and col
                    int next = board[rc[0]][rc[1]] == -1 ? j : board[rc[0]][rc[1]];
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getRC(int num, int n) {
        int quot = (num - 1) / n;
        int rem = (num - 1) % n;
        int row = n - 1 - quot;
        int col = row % 2 != n % 2 ? rem : n - 1 - rem;
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        SnakesAndLadders sl = new SnakesAndLadders();
        System.out.println(sl.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}}));
        System.out.println(sl.snakesAndLadders(new int[][]{
                {-1, -1},
                {-1, 3}}));
    }
}

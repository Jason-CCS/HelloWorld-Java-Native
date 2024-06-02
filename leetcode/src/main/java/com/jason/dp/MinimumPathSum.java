package com.jason.dp;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem: 64
 * Difficulty: Medium
 * The problem is meant to determine the minimum path sum from the top left to the bottom right of a 2D grid
 * where you can only move either down or right
 */
public class MinimumPathSum {
    /**
     * This is my own solution.
     * Too much data structure operations.
     * Time Complexity O(m*n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] e = q.poll();
            int i = e[0];
            int j = e[1];
            int curV = grid[i][j];
            // go right, j+1
            if (j + 1 < n) {
                if (visited[i][j + 1]) { // visited is true
                    // compare with opponent (i-1, j+1)
                    if (curV < grid[i - 1][j + 1])
                        grid[i][j + 1] = grid[i][j + 1] - grid[i - 1][j + 1] + curV;
                } else {
                    grid[i][j + 1] += curV;
                    q.offer(new int[]{i, j+1});
                    visited[i][j + 1] = true;
                }
            }
            // go down, i+1
            if (i + 1 < m) {
                grid[i + 1][j] += curV;
                q.offer(new int[]{i + 1, j});
                visited[i + 1][j] = true;
            }
        }

        return grid[m - 1][n - 1];
    }

    /**
     * This solution is from AI, but much less data structure operations.
     * Time Complexity O(m*n)
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize the first row and first column
        for(int i=1; i<m; i++) grid[i][0] += grid[i-1][0];
        for(int j=1; j<n; j++) grid[0][j] += grid[0][j-1];

        // For each remaining cell, calculate min sum path
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
            }
        }

        // The minimum path sum will be the last cell
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] tc1 = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int[][] tc2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] tc3 = new int[][]{{1, 4, 8, 6, 2, 2, 1, 7}, {4, 7, 3, 1, 4, 5, 5, 1}, {8, 8, 2, 1, 1, 8, 0, 1}, {8, 9, 2, 9, 8, 0, 8, 9}, {5, 7, 5, 7, 1, 8, 5, 5}, {7, 0, 9, 4, 5, 6, 5, 6}, {4, 9, 9, 7, 9, 1, 9, 0}};
        MinimumPathSum problem = new MinimumPathSum();
//        System.out.println(problem.minPathSum(tc1));
//        System.out.println(problem.minPathSum(tc2));
        System.out.println(problem.minPathSum(tc3));
    }
}

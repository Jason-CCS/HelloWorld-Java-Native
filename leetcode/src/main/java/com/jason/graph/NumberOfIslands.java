package com.jason.graph;

/**
 * Problem: 200
 * Difficulty: Medium
 * The purpose of the problem is to count the number of islands in a given 2D grid map,
 * where an island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    checkAdjacency(grid, i, j, grid.length, grid[i].length);
                    counter++;
                }
            }
        }

        return counter;
    }

    public void checkAdjacency(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            checkAdjacency(grid, i - 1, j, m, n);
        if (i + 1 != m && grid[i + 1][j] == '1')
            checkAdjacency(grid, i + 1, j, m, n);
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            checkAdjacency(grid, i, j - 1, m, n);
        if (j + 1 != n && grid[i][j + 1] == '1')
            checkAdjacency(grid, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}

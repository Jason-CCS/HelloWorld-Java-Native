package com.jason.divide_and_conquer;

/**
 * Problem: 427
 * Difficulty: Medium
 * The purpose of the problem is to construct a Quad Tree by dividing a 2D array into four equal parts or leaves based on the unique values it contains.
 */
public class ConstructQuadTree {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    /**
     * This approach might access many times for the same element in the grid matrix.
     * Therefore, the time complexity is not very good.
     * We can consider calculating the index of the subgrid instead of directly deriving the subgrid.
     * @param grid
     * @return
     */
    public Node construct(int[][] grid) {
        Node root = new Node();
        if (grid.length == 1) {
            root.val = (grid[0][0] == 1);
            root.isLeaf = true;
        } else {
            Node tl = construct(subGrid(grid, "tl"));
            Node tr = construct(subGrid(grid, "tr"));
            Node bl = construct(subGrid(grid, "bl"));
            Node br = construct(subGrid(grid, "br"));
            if ((tl.val == tr.val) && (tl.val == bl.val) && (tl.val == br.val) && (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf)) {
                root.val = tl.val;
                root.isLeaf = true;
            } else {
                root.val = true;
                root.isLeaf = false;
                root.topLeft = tl;
                root.topRight = tr;
                root.bottomLeft = bl;
                root.bottomRight = br;
            }
        }
        return root;
    }

    private int[][] subGrid(int[][] grid, String whichPart) {
        int l = grid.length;
        int mStart = 0, mEnd = 0, nStart = 0, nEnd = 0;
        switch (whichPart) {
            case "tl":
                mEnd = l / 2;
                nEnd = l / 2;
                break;
            case "tr":
                mEnd = l / 2;
                nStart = l / 2;
                nEnd = l;
                break;
            case "bl":
                mStart = l / 2;
                mEnd = l;
                nEnd = l / 2;
                break;
            case "br":
                mStart = l / 2;
                mEnd = l;
                nStart = l / 2;
                nEnd = l;
                break;
        }
        int[][] subGrid = new int[l / 2][l / 2];
        for (int i = 0, m = mStart; m < mEnd; i++, m++) {
            for (int j = 0, n = nStart; n < nEnd; j++, n++) {
                subGrid[i][j] = grid[m][n];
            }
        }
        return subGrid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        Node node = new ConstructQuadTree().construct(grid);
        System.out.println("debug");
    }
}

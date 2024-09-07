package com.jason.sort_and_search.binary_search;

/**
 * Problem: 74
 * Difficulty: Medium
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            int midVal = matrix[mid / n][mid % n];
            if (target == midVal) {
                return true;
            } else {
                if (target < midVal) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}

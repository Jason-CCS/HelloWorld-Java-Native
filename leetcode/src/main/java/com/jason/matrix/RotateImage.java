package com.jason.matrix;

import java.util.Arrays;

/**
 * Problem: 48
 * Difficulty: Medium
 * Problem Description: The purpose of this problem is to rotate a given NxN 2D matrix 90 degrees clockwise.
 */
public class RotateImage {
    /**
     * Use image processing concept.
     * Transpose and reverse.
     * Time Complexity is O(n^2)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // transpose matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}

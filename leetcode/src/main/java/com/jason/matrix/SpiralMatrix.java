package com.jason.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 54
 * Difficulty: Medium
 * Problem Description: The purpose of this problem is to return all elements of a given 2D matrix in a spiral order.
 */
public class SpiralMatrix {
    /**
     * This approach definitely is from internet.
     * Key point:
     * 使用top, left, bottom, right來track下一個起始點要從哪邊開始，也就是先matrix[0, 0], 下一個起始點[top++, right],
     * 下一個起始點[bottom, right--], 下一個起始點[bottom--, left++]
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return resultList;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) {
                resultList.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                resultList.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) break;
        }

        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}

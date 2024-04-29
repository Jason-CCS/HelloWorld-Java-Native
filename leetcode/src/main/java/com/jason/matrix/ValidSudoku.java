package com.jason.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: 36
 * Difficulty: Medium
 * Problem Description: The purpose of this problem is to validate whether a partially filled Sudoku board
 * follows the rules of the game, where each row, each column, and each of the nine 3x3 sub-grids must contain
 * all the digits from 1 through 9 without repetition.
 */
public class ValidSudoku {
    private static final int size = 9;

    /**
     * Version 1
     * My solution use more computation complexity on create the HashSet and the operation on HashSet.
     * So even the time complexity is O(n), it has more overhead than Version 2.
     * Time Complexity: O(n)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[size];
        HashSet<Character>[] cols = new HashSet[size];
        HashSet<Character>[][] subBoxMatrix = new HashSet[size / 3][size / 3];
        for (int i = 0; i < size; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < size / 3; i++) {
            for (int j = 0; j < size / 3; j++) {
                subBoxMatrix[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!checkAndAddCharacter(rows[i], board[i][j]) ||
                        !checkAndAddCharacter(cols[j], board[i][j]) ||
                        !checkAndAddCharacter(subBoxMatrix[i / 3][j / 3], board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkAndAddCharacter(Set<Character> set, char character) {
        if (character == '.')
            return true;
        return set.add(character);
    }

    /**
     * Version 2
     * Use array only to count the occurrence of each digit.
     * Overhead is lower.
     * Time Complexity: O(n)
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        // single-count array for all numbers
        int[][] rows = new int[size][size];
        int[][] cols = new int[size][size];
        int[][] boxes = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = Character.getNumericValue(num) - 1;
                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i][n]++;
                    cols[j][n]++;
                    boxes[box_index][n]++;

                    if (rows[i][n] > 1 || cols[j][n] > 1 || boxes[box_index][n] > 1)
                        return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        ValidSudoku validSudoku = new ValidSudoku();
        boolean isValid = validSudoku.isValidSudoku2(board);
        System.out.println(isValid);
    }
}

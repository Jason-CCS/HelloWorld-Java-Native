package com.jason.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 17
 * Difficulty: Medium
 * The purpose of the problem is to generate all possible letter combinations that a given sequence of digits could represent on a dial pad of a telephone
 *
 * Backtracking is a problem-solving algorithmic technique that involves finding a solution incrementally
 * by trying different options and undoing them if they lead to a dead end. It is commonly used in situations
 * where you need to explore multiple possibilities to solve a problem, like searching for a path in a maze or
 * solving puzzles like Sudoku. When a dead end is reached, the algorithm backtracks to the previous decision point
 * and explores a different path until a solution is found or all possibilities have been exhausted.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsHelper(result, digits, "", 0, mapping);
        return result;
    }
    private void letterCombinationsHelper(List<String> result, String digits, String current, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(result, digits, current + letters.charAt(i), index + 1, mapping);
        }
    }
}

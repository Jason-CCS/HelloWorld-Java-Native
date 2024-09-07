package com.jason.stack_and_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 22
 * Difficulty: Medium
 * 如果你要改變下一層function的變數state，則你要使用left+1, 而不是left++，因為這會影響到目前這層function的state，
 * 如果你想要在所有stack都共用相同狀態的變數，那需要pass by reference，就像這題的StringBuilder。
 */
public class GenerateParentheses {
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(n, '(', 1, 0, new StringBuilder());
        return list;
    }

    /**
     * This is a branch and bound approach, and basically it is backtracking also.
     *
     * @param n
     * @param c
     * @param left
     * @param right
     * @param sb
     */
    public void helper(int n, char c, int left, int right, StringBuilder sb) {
        if (c == '(')
            sb.append(c);
        else if (right > left) // bound
            return;
        else
            sb.append(c);
        if (left < n) // branch
            helper(n, '(', left + 1, right, sb);
        if (right < n) // branch
            helper(n, ')', left, right + 1, sb);
        if (left == n && right == n) {
            list.add(sb.toString());
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
        System.out.println(new GenerateParentheses().generateParenthesis(5));
    }
}

package com.jason.stack_and_queue;

import java.util.*;

/**
 * Problem: 71
 * Difficulty: Medium
 * The purpose of the problem in the editor is to simplify a Unix-style file path to its shortest normal form.
 */
public class SimplifyPath {
    /**
     * Version 1
     * Time complexity is O(n).
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        int end = path.length() - 1;
        int start;
        while (end >= 0) {
            // case 1: "/", then find next end until "not /"
            while (end >= 0 && path.charAt(end) == '/') {
                end--;
            }
            // case 2: "not /", then find start until "/"
            start = end;
            while (start >= 0 && path.charAt(start) != '/') {
                start--;
            }
            if (start < end)
                stack.push(path.substring(start + 1, end + 1));
            end = start;
        }

        while (!stack.isEmpty()) {
            String token = stack.pop();
            if (token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                int index = result.lastIndexOf("/");
                if (index != -1) {
                    result.delete(index, result.length());
                }
            } else {
                result.append("/" + token);
            }
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    /**
     * Version 2
     * This version is from internet.
     * It looks elegant, but the time efficiency is not better than version 1.
     * Time complexity is O(n).
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack)
            result.insert(0, "/" + dir);
        return (result.length() == 0) ? "/" : result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/home/"));
        System.out.println(sp.simplifyPath("/../../../b/"));
        System.out.println(sp.simplifyPath("/home//foo/"));
        System.out.println(sp.simplifyPath("/a/./b/../c"));
    }
}

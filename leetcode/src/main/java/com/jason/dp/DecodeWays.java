package com.jason.dp;

import com.jason.CheatSheet;

import java.util.*;

/**
 * Problem: 198
 * Difficulty: Medium
 * The problem in the editor is to determine the number of ways a given digit string can be decoded into a sequence of
 * letters according to the mapping where A=1, B=2, ..., Z=26.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        else if (s.length() == 1) return 1;
        HashMap<Elem, Integer> dp = new HashMap<>();
//        dfs(0, 1, s, dp);
//        dfs(0, 2, s, dp);
        return dfs(0, 1, s, dp) + dfs(1, 2, s, dp);
    }

    static class Elem {
        int x;
        int y;

        public Elem(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Elem e = (Elem) o;
            return x == e.x && y == e.y;
        }

        // Override hashCode method
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * My approach.
     * Using DFS to backtracking and use DP to minimize the running time.
     * Time Complexity:
     *
     * @param curIdx
     * @param padding
     * @param s
     * @param dp
     * @return
     */
    private int dfs(int curIdx, int padding, String s, HashMap<Elem, Integer> dp) {
        if (curIdx < s.length()) {
            // base cases
            Elem key = new Elem(curIdx, padding);

            if (padding == 1) {
                if (dp.containsKey(key))
                    return dp.get(key);
                if (s.charAt(curIdx) == '0') {
                    dp.put(key, 0);
                    return 0;
                } else {
                    if (curIdx == s.length() - 1) {
                        dp.put(key, 1);
                        return 1;
                    }
                }
            }
            if (padding == 2) {
                if (dp.containsKey(key))
                    return dp.get(key);
                if (s.charAt(curIdx - 1) == '0' || Integer.parseInt(s.substring(curIdx - 1, curIdx + 1)) > 26) {
                    dp.put(key, 0);
                    return 0;
                } else {
                    if (curIdx == s.length() - 1) {
                        dp.put(key, 1);
                        return 1;
                    }
                }
            }
            // traverse
            int padding1 = dfs(curIdx + 1, 1, s, dp);
            int padding2 = dfs(curIdx + 2, 2, s, dp);
//            dp.put(curIdx + 1, padding1);
//            dp.put((curIdx + 1) * 10 + curIdx + 2, padding2);
            if (padding == 1) {
                dp.put(key, padding1 + padding2);
                return dp.get(key);
            } else {
                dp.put(key, padding1 + padding2);
                return dp.get(key);
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("10"));
        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("226"));
        System.out.println(new DecodeWays().numDecodings("06"));
        System.out.println(new DecodeWays().numDecodings("11106"));
        System.out.println(new DecodeWays().numDecodings("2611055971756562"));
    }
}

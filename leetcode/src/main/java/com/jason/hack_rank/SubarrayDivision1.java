package com.jason.hack_rank;

import java.util.*;

/**
 * I misunderstand this problem.
 * It said "to share a contiguous segment of the bar", but what I implemented was not contiguous segment.
 * What I've done here is a combination of choco if choco is available.
 */
public class SubarrayDivision1 {
    public static int result = 0;
    public static HashSet<LinkedList<Integer>> set = new HashSet<>();

    public static Set<LinkedList<Integer>> birthday(List<Integer> s, int d, int m) {
        // Write your code here
        if (d - m * 5 > 0 || m > d)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : s) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        helper(0, map, 0, m, d, new LinkedList<Integer>());

        return set;
    }

    public static void helper(int idx, HashMap<Integer, Integer> map, int sum, int m, int d, LinkedList<Integer> comb) {
        if (idx > m || sum > d) {
            return;
        }
        if (idx == m) {
            if (sum == d) {
                Collections.sort(comb);
                if (!set.contains(comb)) {
                    set.add(comb);
                    result++;
                }
            }
            return;
        }
        for (Integer candidateNum = 1; candidateNum <= 5 && candidateNum <= (d - sum); candidateNum++) {
            if (map.get(candidateNum) != null && map.get(candidateNum) != 0) {
                map.put(candidateNum, map.get(candidateNum) - 1);
                comb.add(candidateNum);
                helper(idx + 1, new HashMap<>(map), sum + candidateNum, m, d, new LinkedList<>(comb));
                comb.remove(candidateNum);
                map.put(candidateNum, map.get(candidateNum) + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(birthday(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1), 18, 7));
    }

}

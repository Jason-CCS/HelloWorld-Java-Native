package com.jason.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 56
 * Difficulty: Medium
 * The purpose of the problem currently in the editor is to merge all overlapping intervals in a given set of intervals,
 * and return an array of the non-overlapping intervals sorted by their start time.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]); // O(n*log(n))

        List<int[]> list = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length) { // O(n)
            int start = intervals[idx][0];
            int end = intervals[idx][1];
            int next = idx + 1;
            while (next < intervals.length && end >= intervals[next][0]) {
                end = Math.max(end, intervals[next][1]);
                next++;
            }
            idx = next;
            list.add(new int[]{start, end});
        }

        int[][] res = list.toArray(new int[list.size()][]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}

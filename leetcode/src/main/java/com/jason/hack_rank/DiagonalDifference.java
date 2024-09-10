package com.jason.hack_rank;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int m = arr.size();
        int[] slash = {0, 0};
        int[] backSlash = {0, m - 1};
        int slashSum = 0;
        int backSlashSum = 0;

        while (slash[0] < m) {
            slashSum += arr.get(slash[0]).get(slash[1]);
            slash[0]++;
            slash[1]++;
        }

        while (backSlash[0] < m) {
            backSlashSum += arr.get(backSlash[0]).get(backSlash[1]);
            backSlash[0]++;
            backSlash[1]--;
        }

        return Math.abs(slashSum - backSlashSum);
    }
}

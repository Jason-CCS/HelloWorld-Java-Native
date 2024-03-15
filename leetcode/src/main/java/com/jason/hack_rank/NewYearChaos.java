package com.jason.hack_rank;

import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;

        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        minimumBribes(List.of(1, 2, 5, 3, 7, 8, 6, 4));
    }
}

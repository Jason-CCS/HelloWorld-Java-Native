package com.jason.hack_rank;

import java.util.Arrays;
import java.util.List;

/**
 * This is a good problem to train the logic thinking.
 */
public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;

        for (int i = q.size() - 1; i >= 0; i--) {
            // if the label got from i differentiate the label it originally should be, and result is greater than 2
            // it means too chaotic.
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) { // count the person at label j has been bribed how many times.
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
    }
}

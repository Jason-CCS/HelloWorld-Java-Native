package com.jason.hack_rank;

import java.util.*;

public class GroupDivision {

    /**
     * O(n*log(n))
     * @param levels
     * @param maxSpread
     * @return
     */
    public static int groupDivision(List<Integer> levels, int maxSpread) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(levels);
        int curLevel;
        int maxLevel = 0;
        int counter = 0;
        int numGroup = 0;

        while (!minHeap.isEmpty()) {
            curLevel = minHeap.poll();
            if (counter == 0) {
                numGroup++;
                counter++;
                maxLevel = curLevel + maxSpread;
            } else {
                if (curLevel > maxLevel) {
                    counter = 1;
                    numGroup++;
                    maxLevel = curLevel + maxSpread;
                } else {
                    counter++;
                }
            }
        }

        return numGroup;
    }

    public static void main(String[] args) {
        System.out.println(groupDivision(Arrays.asList(1, 4, 7, 3, 4), 2));

    }
}

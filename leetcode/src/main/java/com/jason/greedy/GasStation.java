package com.jason.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: 134
 * Difficulty: Medium
 * The problem is to find the starting gas station such that you can complete the circuit once
 * if you know the amount of gas in each station and the distance to the next station.
 */
public class GasStation {
    /**
     * version 1
     * This solution meet TLE.
     * Time complexity is O(k*n)
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int aryLength = gas.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < aryLength; i++) {
            if (gas[i] >= cost[i]) {
                maxHeap.add(i);
            }
        }

        while (!maxHeap.isEmpty()) { // O(k), if we have k elements.
            int start = maxHeap.poll();
            int tank = gas[start];
            int currentIdx = start;
            while (tank >= cost[currentIdx]) {
                tank -= cost[currentIdx];
                currentIdx = (currentIdx + 1) % aryLength;
                if (currentIdx == start) { // for each of elem in heap, we have to go one round of the circuit, it will cause O(k*n)
                    return start;
                }
                tank += gas[currentIdx];
            }
        }

        return -1;
    }

    /**
     * Version 2
     * Use greedy approach.
     * Time complexity is O(n).
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int startIdx = -1;
        int totalSum = 0;
        int accSum = 0;
        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalSum += net;
            if (net >= 0 && startIdx == -1) { // set local optimal，成功開始，又累積和accSum以及全部和totalSum大於等於0
                startIdx = i;
            }
            if (startIdx != -1) {
                accSum += net;
                if (accSum < 0) { // cancel local optimal
                    startIdx = -1;
                    accSum = 0;
                }
            }
        }

        if (totalSum >= 0)
            return startIdx;
        else
            return -1;
    }
}

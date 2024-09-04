package com.jason.hack_rank;

import java.util.*;

public class FileProtection {
    public static int getMinimumChanges(List<Integer> fileSize, List<Integer> minSize) {
        // Write your code here
        int n = fileSize.size();
        int numOfNegative = 0;
        int sumOfNegative = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o2.val - o1.val;
            }
        });

        for (int i = 0; i < n; i++) {
            if (fileSize.get(i) - minSize.get(i) > 0) {
                pq.offer(new Tuple(fileSize.get(i) - minSize.get(i), i));
            } else if (fileSize.get(i) - minSize.get(i) < 0) {
                numOfNegative++;
                sumOfNegative += (fileSize.get(i) - minSize.get(i));
            }
        }
        if (numOfNegative == 0)
            return 0;

        int numberChanged = numOfNegative;
        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            if (t.val + sumOfNegative >= 0) {
                return numberChanged + 1;
            } else {
                sumOfNegative = t.val + sumOfNegative;
                numberChanged++;
            }
        }

        return -1;
    }

    public static class Tuple {
        int val;
        int index;

        public Tuple(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(getMinimumChanges(
                Arrays.asList(1, 3, 5, 7, 9),
                Arrays.asList(5, 5, 5, 5, 5)));
    }
}

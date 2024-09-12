package com.jason.hack_rank;

import java.util.*;

public class MaxKnowledgeGain {

    public static void main(String[] args) {
        long knowledgeGained = getMaxKnowledge(10, Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4),
                Arrays.asList(7, 5, 7, 7, 8, 7, 8, 6, 9, 10),
                Arrays.asList(500, 300, 500, 400, 500, 800, 600, 300, 500, 300), 2);
        System.out.println(knowledgeGained);
    }

    /**
     * O(n*log(n)+m), m is number of meeting.
     * @param d
     * @param s
     * @param e
     * @param a
     * @param k
     * @return
     */
    public static long getMaxKnowledge(int d, List<Integer> s, List<Integer> e, List<Integer> a, int k) {
        List<Meeting> list = new ArrayList<>();

        for (int i = 0; i < s.size(); i++) {
            list.add(new Meeting(s.get(i), e.get(i), a.get(i)));
        }

        list.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return Integer.compare(m2.a, m1.a);
            }
        });

        int[] counter = new int[d + 1];
        int[] total = new int[d + 1];
        for (Meeting m : list) {
            for (int day = m.s; day <= m.e; day++) { // Greedy: 因為我已經排序max to min，所以先塞進去total的都是比較大的，所以如果滿到=k，那一定是那一天最多的Knowledge Gain.
                if (counter[day] != k) {
                    total[day] += m.a;
                    counter[day]++;
                }
            }
        }

        return Arrays.stream(total).max().orElse(0);
    }

    static class Meeting {
        int s;
        int e;
        int a;

        public Meeting(int s, int e, int a) {
            this.s = s;
            this.e = e;
            this.a = a;
        }
    }
}

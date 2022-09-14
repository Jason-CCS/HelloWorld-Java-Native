package com.jason.leetcode;

import java.util.*;

public class L1 {
    public static void main(String[] args) {
        L1 sol = new L1();
        System.out.println(sol.solution(1, 5, 100));
    }

    String solution(int A, int B, int C) {
        Elem a = new Elem("a", A);
        Elem b = new Elem("b", B);
        Elem c = new Elem("c", C);
        List<Elem> elemList = new ArrayList<>();
        elemList.addAll(Arrays.asList(a, b, c));

        List<Elem> orderedList = orderDesc(elemList);
        StringBuilder sb = new StringBuilder();

        while (orderedList.get(0).getTimes() > 0) {
            Elem firstEle = orderedList.get(0);
            Elem secondEle = orderedList.get(1);
            Elem appendEle = null;
            if (sb.length() == 0) {
                appendEle = firstEle;
            } else if (!sb.substring(sb.length() - 1, sb.length()).equals(firstEle.getKey())) {
                appendEle = firstEle;
            } else {
                appendEle = secondEle;
            }

            if (appendEle.equals(firstEle)) {
                if (appendEle.getTimes() > 1) {
                    sb.append(appendEle.getKey()).append(appendEle.getKey());
                    Integer remaining = appendEle.getTimes() - 2;
                    appendEle.setTimes(remaining);
                } else {
                    sb.append(appendEle.getKey());
                    Integer remaining = appendEle.getTimes() - 1;
                    appendEle.setTimes(remaining);
                }
            } else {
                if (appendEle.getTimes() > 0) {
                    sb.append(appendEle.getKey());
                    Integer remaining = appendEle.getTimes() - 1;
                    appendEle.setTimes(remaining);
                } else {
                    break;
                }
            }

            orderDesc(orderedList);
        }
        return sb.toString();
    }

    static class Elem {
        String key;
        Integer times;

        Elem(String key, Integer times) {
            this.key = key;
            this.times = times;
        }

        String getKey() {
            return this.key;
        }

        Integer getTimes() {
            return this.times;
        }

        void setTimes(Integer times) {
            this.times = times;
        }
    }

    static List<Elem> orderDesc(List<Elem> elemList) {
        Collections.sort(elemList, new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return o2.getTimes() - o1.getTimes();
            }
        });

        return elemList;
    }
}

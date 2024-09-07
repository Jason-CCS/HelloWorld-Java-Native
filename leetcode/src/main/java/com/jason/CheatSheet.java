package com.jason;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class CheatSheet {

    @Test
    public void test1() {
        /**
         * As for TreeSet, TreeMap, PriorityQueue, they need to compare. Please implement the Comparator.
         */
        TreeSet<Elem> treeSet = new TreeSet<>(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                int numComparison = Integer.compare(o1.num, o2.num); // descending
                return numComparison != 0 ? numComparison : Integer.compare(o1.freq, o2.freq); // 先以num排序為主，再以freq排序為次
            }
        });

        System.out.println(treeSet.add(new Elem(1, 30)));
        System.out.println(treeSet.add(new Elem(2, 30)));
        System.out.println(treeSet.add(new Elem(1, 31)));
        System.out.println(treeSet.add(new Elem(1, 30)));
        for (Elem elem : treeSet) {
            System.out.println(elem);
        }
    }

    /**
     * If you have your class as a type in any collection data structure,
     * you will need to override the below functions so as to successfully run equals().
     */
    static class Tuple {
        private final int start;
        private final int end;

        public Tuple(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // Override equals method
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return start == tuple.start && end == tuple.end;
        }

        // Override hashCode method
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    /**
     * Customized KV Elem.
     */
    static class Elem {
        int num;
        int freq;

        public Elem(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return String.format("num: %d, freq: %d", num, freq);
        }
    }
}

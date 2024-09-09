package com.jason;

import com.jason.interval.MergeIntervals;
import org.junit.Test;

import java.util.*;

public class CheatSheet {
    /**
     * 雜項
     */
    @Test
    public void test() {
        // 字串取代成只有大小寫字母與數字的字串。
        String str = "AJOI#02384-20i:KY:BKK_)*%)@VN>DFJ>".toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(str);

        // deep toString() function for a nested array.
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    /**
     * min or max heap, min heap is default.
     */
    @Test
    public void test1() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // This is default setting. It is min heap.
                // return o2 - o1 // This is max heap.
            }
        });
        minHeap.offer(1);
        Integer min = minHeap.poll();
    }

    /**
     * As for TreeSet, TreeMap, PriorityQueue, they need to compare. Please implement the Comparator.
     * This implement red-black tree. If you need an ordered and deduplicated set, then you can use this one.
     */
    @Test
    public void test2() {
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
     * TreeMap sort with Comparator.
     */
    @Test
    public void test3() {
        TreeMap treeMap = new TreeMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
//                if (o1 < o2)
//                    return negative int;
//                else if (o1 == o2)
//                    return 0;
//                else // o1 > o2
//                    return positive int;
                return 0;
            }
        });
        treeMap.put(new Object(), new Object());
        treeMap.remove(new Object());
    }

    /**
     * ArrayList sort with Comparator.
     */
    @Test
    public void test4() {
        ArrayList<Elem> arrayList = new ArrayList<>();
        arrayList.add(new Elem(1, 30));
        arrayList.add(new Elem(2, 29));
        arrayList.add(new Elem(3, 28));

        arrayList.sort(new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return Integer.compare(o1.freq, o2.freq);
            }
        });

        arrayList.forEach(elem -> System.out.println(elem));
    }

    /**
     * Personal-made class is used as key in HashMap.
     * How to override the equal method in class.
     */
    @Test
    public void test5() {
        HashMap<Tuple, String> map = new HashMap<>();
        map.put(new Tuple(100, 200), "100~200");
        map.put(new Tuple(100, 201), "100~201");
        map.put(new Tuple(100, 202), "100~202");
        map.put(new Tuple(100, 200), "100~200");

        System.out.println("Thinking it is four?");
        System.out.println("But it is 3.");
        System.out.printf("map size is %d%n", map.size());
    }

    /**
     * Two pointers.
     */
    @Test
    public void test6() {
        int[] nums = {1, 2, 3, 3, 5, 6, 7, 8, 8, 9};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // we don't want the nums[left] equal to nums[left-1], the previous number.
            System.out.println(nums[left] + " " + nums[right]);
            left++;
            right--;
            while (nums[left] == nums[left - 1]) { // 如果我們希望某些條件left and right move多一些。
                left++;
            }
            while (nums[right] == nums[right + 1]) {
                right--;
            }
        }
    }

    /**
     * BFS
     */
    @Test
    public void test7() {
        // BFS
        Queue<DataStructure.Node> queue = new LinkedList<>();

    }

    /**
     * Binary Search Pattern
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // This is really key point. right is nums.length, rather than nums.length-1.

        while (left < right) {
            int m = (left + right) / 2;
            if (nums[m] == target) {
                return m;
            } else {
                if (target < nums[m])
                    right = m;
                else
                    left = m + 1;
            }
        }

        return -1;
    }

    /**
     * If you have your class as a type in any collection data structure,
     * you will need to override the below functions to successfully run equals().
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

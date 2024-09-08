package com.jason.hack_rank;

import java.util.*;

public class Pairs {
    public static List<int[]> pairs(int k, List<Integer> arr) {
        // Write your code here
        int counter = 0;
        HashSet<Integer> set = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();
        for (int num : arr) {
            if (!set.contains(num)) {
                if (set.contains(num - k))
                    pairs.add(new int[]{num, num - k});
                if (set.contains(num + k))
                    pairs.add(new int[]{num + k, num});
                set.add(num);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        List<int[]> list = pairs(2, Arrays.asList(1, 5, 3, 4, 2));
        System.out.println(list.size());
        list.forEach(a -> System.out.println(Arrays.toString(a)));
    }
}

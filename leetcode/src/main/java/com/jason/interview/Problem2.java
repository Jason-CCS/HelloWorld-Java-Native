package com.jason.interview;

import java.util.Arrays;
import java.util.HashMap;

public class Problem2 {

    public static void main(String[] args) {
        int[] a = {9, 6, 3}; // 18
        int[] b = {3, 4, 5}; // 12

        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;
        int i = 0, j = 0;
        while (!found && i < a.length) {
            if ((sumB - sumA) % 2 != 0) {
                break;
            }
            int y = a[i] + (sumB - sumA) / 2;
            map.put(y, i);
            i++;
            while (!found && j < b.length) {
                if (map.containsKey(b[j])) {
                    found = true;
                    System.out.println(String.format("%d in a, and %d in b", a[map.get(b[j])], b[j]));
                }
                j++;
            }
            j = 0;
        }

        System.out.println(found);
    }

    private static int sum(Integer[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}

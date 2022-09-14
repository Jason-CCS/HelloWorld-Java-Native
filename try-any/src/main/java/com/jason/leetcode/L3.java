package com.jason.leetcode;

public class L3 {
    private static int steps = 0;
    private static int counter = 0;

    public static void main(String[] args) {
        getTriangle(1000);
        System.out.println(steps);
        System.out.println(counter);
        steps = 0;
        counter = 0;
        quickTriangle(1000);
        System.out.println(steps);
        System.out.println(counter);
    }

    public static void getTriangle(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j < i + i; j++) {
                steps++;
                if (i != j && 2 * i + j <= length) {
                    counter++;
//                    System.out.println(String.format("(%s, %s, %s)", i, i, j));
                }
            }
        }
    }

    public static void quickTriangle(int length) {
        for (int i = 1; i <= length; i++) {
            int start = Math.min(2 * i - 1, length - 2 * i);
            for (int j = start; j > 0; j--) {
                steps++;
                if (i != j) {
                    counter++;
//                    System.out.println(String.format("(%s, %s, %s)", i, i, j));
                }
            }
        }
    }
}

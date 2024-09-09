package com.jason.hack_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            System.out.println("0.000000");
            System.out.println("0.000000");
            System.out.println("0.000000");
            return;
        }

        int n = arr.size();
        int ps = 0, ns = 0, zs = 0;
        for (int i : arr) {
            if (i > 0) {
                ps++;
            } else if (i < 0) {
                ns++;
            } else {
                zs++;
            }
        }
        float pRatio = ps / (float) n;
        float nRatio = ns / (float) n;
        float zRatio = zs / (float) n;

        System.out.println(String.format("%.6f", pRatio));
        System.out.println(String.format("%.6f", nRatio));
        System.out.println(String.format("%.6f", zRatio));
    }

    public static void main(String[] args) {
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
    }

}

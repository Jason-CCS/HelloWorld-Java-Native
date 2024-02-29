package com.jason.hashtable;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This is, to be honest speaking, a problem to practice the coding.
 * I don't think it really relates to HashTable or two pointers.
 */
public class IsHappy {
    public boolean isHappy(int n) {
        try {
            HashSet<Integer> set = new HashSet<>();
            do {
                ArrayList<Integer> digitArrayList = toDigitArrayList(n);
                n = squareSum(digitArrayList);
                if (set.contains(n))
                    return false;
                if (n != 1)
                    set.add(n);
            } while (n != 1);
            return true;
        } catch (ArithmeticException e) {
            return false;
        }
    }

    public int squareSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum = sum + i * i;
        }
        return sum;
    }

    public ArrayList<Integer> toDigitArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] chars = Integer.toString(n).split("");
        for (String c : chars)
            list.add(Integer.parseInt(c));
        return list;
    }

    public static void main(String[] args) {
        IsHappy problem = new IsHappy();
        for (int i = 0; i < 1000; i++) {
            System.out.println(problem.isHappy(i));
        }
//        System.out.println(problem.isHappy(19));
    }
}

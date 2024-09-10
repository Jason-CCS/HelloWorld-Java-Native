package com.jason.hack_rank;

import java.util.Arrays;
import java.util.HashSet;

public class Pangrams {
    public static String pangrams(String s) {
        // Write your code here
        HashSet<Character> set = new HashSet<>();
        String alpahbets = "abcdefghijklmnopqrstuvwxyz";
        for (char c : alpahbets.toCharArray()) {
            set.add(c);
        }

        for (char c : s.toLowerCase().toCharArray()) {
            set.remove(c);
            if (set.isEmpty()) {
                return "pangram";
            }
        }

        return "not pangram";
    }
}

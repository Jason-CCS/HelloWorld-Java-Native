package com.jason.hack_rank;

public class CaesarCipher {
    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = (Character.isUpperCase(c)) ? 'A' : 'a';
                char rotatedChar = (char) ((c - base + k) % 26 + base);
                sb.append(rotatedChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String tc1 = "zebra";
        System.out.println(caesarCipher(tc1, 10));

    }
}

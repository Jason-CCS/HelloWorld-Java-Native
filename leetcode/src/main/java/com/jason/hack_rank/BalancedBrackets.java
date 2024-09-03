package com.jason.hack_rank;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * The isBalanced function checks if the brackets in the given string are properly balanced using a stack,
 * returning "YES" if balanced and "NO" otherwise.
 */
public class BalancedBrackets {

    private static HashMap<Character, Character> map;

    static {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    /**
     * Worst case O(s.length)
     * @param s
     * @return
     */
    public static String isBalanced(String s) {
        // Write your code here
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)){
                stack.push(map.get(c)); // O(1)
            }else{
                if (stack.isEmpty() || !c.equals(stack.pop())) // O(1)
                    return "NO";
            }
        }
        if (!stack.isEmpty())
            return "NO";
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

package com.jason.interview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Problem {

    private final HashMap<Character, Character> symbolMap;

    public Problem() {
        this.symbolMap = new HashMap<>();
        this.symbolMap.put('}', '{');
        this.symbolMap.put(']', '[');
        this.symbolMap.put(')', '(');
    }

    private boolean solution(String str) {
        Deque<Character> stack = new LinkedList<>();
        for (Character c : str.toCharArray()) {
            if (!symbolMap.containsKey(c)) {
                stack.push(c);
            } else {
                Character leftC = symbolMap.get(c);
                Character popC = stack.pop();
                if (!leftC.equals(popC)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem().solution("{[()({{}{[]})]}"));
    }
}

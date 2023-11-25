package com.jason;

import java.util.*;

/**
 * My solution seems not so good in the Leetcode solutions.
 * Runtime only beats 51.68% of users with Java.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        LinkedHashMap<Character, ArrayList<Integer>> sMap = new LinkedHashMap<>();
        LinkedHashMap<Character, ArrayList<Integer>> tMap = new LinkedHashMap<>();
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            updateMap(sMap, sChar, i);
            updateMap(tMap, tChar, i);
        }

        HashSet<Character> charInPocket = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            if (!charInPocket.contains(sChar)) {
                charInPocket.add(sChar);
                if(!sMap.get(sChar).equals(tMap.get(t.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }

    private void updateMap(Map<Character, ArrayList<Integer>> map, char ch, int index) {
        if (map.containsKey(ch)) {
            map.get(ch).add(index);
        } else {
            ArrayList<Integer> newIndexes = new ArrayList<>();
            newIndexes.add(index);
            map.put(ch, newIndexes);
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", null));
        System.out.println(new IsomorphicStrings().isIsomorphic(null, "test"));
    }

}

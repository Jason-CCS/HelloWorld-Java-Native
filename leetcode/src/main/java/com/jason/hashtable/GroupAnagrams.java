package com.jason.hashtable;

import java.util.*;

/**
 * Problem: 49
 * Difficulty: Medium
 */
public class GroupAnagrams {

    /**
     * The first version.
     * I think this solution is fair enough. I use the way as below to represent the letter combination.
     * And use letter combination as the HashMap key.
     * Example: tee, ete, eet => 2e1t
     * Example: banana, aaabnn, abanan => 3a1b2n
     * letter is in natural order by TreeMap.
     * Time Complexity: O(n*(c+e))
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) { // O(n)
            String comb = letterCombination(str);
            if (map.containsKey(comb)) {
                map.get(comb).add(str);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(str);
                map.put(comb, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static String letterCombination(String inputString) { // O(c+e)
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (char c : inputString.toCharArray()) { // O(c)
            if (treeMap.containsKey(c)) {
                treeMap.put(c, treeMap.get(c) + 1);
            } else {
                treeMap.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : treeMap.entrySet()) { // O(e)
            sb.append(e.getValue().toString()).append(e.getKey().toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }
}

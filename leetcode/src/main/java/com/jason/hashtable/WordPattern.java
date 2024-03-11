package com.jason.hashtable;

import java.util.HashMap;

/**
 * Problem: 290
 * Difficulty: Easy
 */
public class WordPattern {
    /**
     * First Version
     * Time Complexity: O(n)
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> letterMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();

        char[] letters = pattern.toCharArray();
        String[] words = s.split(" ");
        if (letters.length != words.length)
            return false;

        for (int i = 0; i < letters.length; i++) {
            if (!letterMap.containsKey(letters[i]) && !wordMap.containsKey(words[i])) {
                letterMap.put(letters[i], words[i]);
                wordMap.put(words[i], letters[i]);
            } else {
                if (letterMap.containsKey(letters[i]))
                    if (!letterMap.get(letters[i]).equals(words[i]))
                        return false;
                if (wordMap.containsKey(words[i]))
                    if (!(wordMap.get(words[i]) == letters[i]))
                        return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));

    }
}

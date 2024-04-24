package com.jason.hashtable;

/**
 * Problem: 383
 * Difficulty: Easy
 * Problem Description: The purpose of this problem is to determine if a ransom note can be constructed from a given
 * magazine, such that every character in the ransom note exists in the magazine with a sufficient frequency.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length()>magazine.length())
            return false;
        int[] ransomNoteCount = new int[26];
        int[] magazineCount = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteCount[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (ransomNoteCount[i]>magazineCount[i])
                return false;
        }

        return true;
    }
}

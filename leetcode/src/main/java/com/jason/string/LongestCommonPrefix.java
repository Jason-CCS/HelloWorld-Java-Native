package com.jason.string;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Version 1 is my own version:
 * It's like a brute-force solution.
 * Every time start from the index, and iterate through all the strings in the input array,
 * if we found any character is not the same as the str[i+1].chartAt(index),
 * then we know this is the end to look for the common prefix.
 * If not, then we index++. Go for next iteration str[i].chartAt(index+1).
 * Time complexity is O(k*n). k is the prefix of the common string. n is the number of strings in the list.
 *<p></p>
 * Version 2 is from Leetcode solutions:
 * Sort the strs into lexicographic order so that the last one will differ the most from the first str.
 * So only finding the longest common prefix between first and last str is sufficient.
 * <p></p>
 * Version3 is my own version again:
 * Let longestPrefixLen as the variable to store the longest prefix length.
 * I compare the first str with all other strs.
 * Each time when I compare with other str, the common prefix will be shorter and shorter.
 * So the one shorter than the current longestPrefixLen will be saved into longestPrefixLen to update this variable.
 * Time complexity is O(k*n). k is the prefix of the common string. n is the number of strings in the list.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefixVersion1(String[] strs) {
        if (strs[0].isEmpty())
            return "";
        boolean flag = true;
        String result = "";
        int index = 0;

        while (true) {
            for (int i = 0; i + 1 < strs.length; i++) {
                if (index >= strs[i].length() || index >= strs[i + 1].length()) {
                    flag = false;
                } else {
                    flag = strs[i].charAt(index) == strs[i + 1].charAt(index);
                }
                if (!flag)
                    break;
            }
            if (!flag) {
                return result;
            } else {
                if (index >= strs[0].length())
                    return result;
                result = result.concat(Character.toString(strs[0].charAt(index)));
                index++;
            }
        }
    }

    public static String longestCommonPrefixVersion2(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static String longestCommonPrefixVersion3(String[] strs) {
        int longestPrefixLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            longestPrefixLen = Math.min(longestPrefixLen, strs[i].length());
            for (int j = 0; j < Math.min(longestPrefixLen, strs[i].length()); j++) { // only run the shortest length times.
                if (strs[0].charAt(j) != strs[i].charAt(j))
                    if (j < longestPrefixLen)
                        longestPrefixLen = j;
            }
        }

        return strs[0].substring(0, longestPrefixLen);
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefixVersion2(new String[]{""}));
        System.out.println(longestCommonPrefixVersion2(new String[]{"a"}));
        System.out.println(longestCommonPrefixVersion2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefixVersion2(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefixVersion2(new String[]{"ab", "a"}));
    }
}
